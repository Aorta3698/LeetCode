class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs)
            uf.unite(pair.get(0), pair.get(1));

        for (int i = 0; i < s.length(); i++){
            int root = uf.find(i);
            PriorityQueue<Character> queue = map.getOrDefault(root, new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(root, queue);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            int group = uf.find(i);
            sb.append(map.get(group).poll());
        }

        return sb.toString();
    }

    private class UnionFind{
        int[] idx;
        int[] ranks;
        int count;

        UnionFind(int size){
            idx = IntStream.range(0, size).toArray();
            ranks = new int[size];
            count  = size;
        }

        private int find(int i){
            if (idx[i] == i) return i;
            idx[i] = find(idx[i]);
            return idx[i];
        }

        private void unite(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return;
            count--;

            if (ranks[iRoot] < ranks[jRoot])
                idx[iRoot] = jRoot;
            else if (ranks[iRoot] > ranks[jRoot])
                idx[jRoot] = iRoot;
            else{
                idx[iRoot] = jRoot;
                ranks[jRoot]++;
            }
        }

        private int getCount(){
            return count;
        }
    }
}
