https://leetcode.com/problems/word-ladder-ii/discuss/2426325/Java-or-Build-the-path-graph-or-with-comments
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// ---- Initialize all required data structures ----- //
        wordList.add(beginWord);
        List<List<String>> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        BitSet seen = new BitSet();
        queue.offer(wordList.size()-1);
        seen.set(wordList.size()-1);
        List<Integer>[] map = new ArrayList[wordList.size()];
        List<Integer>[] parent = new ArrayList[wordList.size()];
        Arrays.setAll(map, o -> new ArrayList<>());
        Arrays.setAll(parent, o -> new ArrayList<>());
        int end = -1;
		// -------- Build the connection map and find the target index ------ //
        for (int i = 0; i < wordList.size(); i++){
            for (int j = i+1; j < wordList.size(); j++){
                if (isConnected(wordList.get(i), wordList.get(j))){
                    map[i].add(j);
                    map[j].add(i);
                }
            }
            if (wordList.get(i).equals(endWord)){
                end=i;
            }
        }
		// --------- BFS to build the path graph ---------- //
        while(!queue.isEmpty()){
            BitSet ns = new BitSet();
            for (int sz = queue.size(); sz > 0; --sz){
                int cur = queue.poll();
                if (cur == end){
                    dfs(end, parent, wordList, new LinkedList<>(), ans);
                    return ans;
                }
                for (int next : map[cur]){
                    if (!seen.get(next) && !ns.get(next)){
                        queue.offer(next);
                        ns.set(next);
                    }
                    if (!seen.get(next)){
                        parent[next].add(cur);
                    }
                }
            }
            seen.or(ns);
        }
        return ans;
    }
    // ------- DFS to build the path in the graph from 1 root to another root ------- //
    private void dfs(int cur, List<Integer>[] parent, List<String> w, LinkedList<String> path, List<List<String>> ans){
        path.addFirst(w.get(cur));
        for (int p : parent[cur]){
            dfs(p, parent, w, path, ans);
        }
        if (parent[cur].isEmpty()){
            ans.add(new ArrayList<>(path));
        }
        path.removeFirst();
    }
	// ------ Return true if 2 words are connected, otherwise return false ------ //
    private boolean isConnected(String a, String b){
        for (int i = 0, count = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i) && ++count>1){
                return false;
            }
        }
        return true;
    }
}
