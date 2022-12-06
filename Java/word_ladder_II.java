https://leetcode.com/problems/word-ladder-ii/discuss/1635597/Java-or-Slight-Modification-from-Word-Ladder-or-BFS-only-or-Explained.
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++)
            if (connected(beginWord, wordList.get(i)))
                map.computeIfAbsent(-1, o -> new ArrayList<>()).add(i);

        int target = -2;
        for (int i = 0; i < wordList.size(); i++){
            if (wordList.get(i).equals(endWord)) target = i;
            for (int j = i + 1; j < wordList.size(); j++){
                if (connected(wordList.get(i), wordList.get(j))){
                    map.computeIfAbsent(i, o -> new ArrayList<>()).add(j);
                    map.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>(List.of(new Node(-1, null)));
        List<List<String>> ans = new ArrayList<>();
        boolean[] seen = new boolean[wordList.size() + 1];

        while(!queue.isEmpty() && ans.isEmpty()){
            int size = queue.size();
            while(--size >= 0){
                Node node = queue.poll();
                int cur = node.get();
                if (cur == target) ans.add(getPath(node, wordList, beginWord));
                seen[cur + 1] = true;
                for (int next : map.getOrDefault(cur, Collections.emptyList()))
                    if(!seen[next + 1]) queue.offer(new Node(next, node));
            }
        }

        return ans;
    }

    private List<String> getPath(Node cur, List<String> words, String s){
        LinkedList<String> path = new LinkedList<>();
        while(cur != null){
            path.addFirst(cur.get() == -1? s : words.get(cur.get()));
            cur = cur.getParent();
        }

        return path;
    }

    private static boolean connected(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i) && ++count == 2)
                return false;
        return true;
    }

    private class Node{
        private int cur;
        private Node parent;

        Node(int cur, Node parent){
            this.cur = cur;
            this.parent = parent;
        }

        Node getParent(){
            return parent;
        }

        int get(){
            return cur;
        }
    }
}
