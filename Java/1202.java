class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        UF uf = new UF(s.length());
        for (List<Integer> p : pairs){
            uf.union(p.get(0), p.get(1));
        }
        for (int i = 0; i < s.length(); i++){
            map.computeIfAbsent(uf.find(i), o -> new PriorityQueue<>()).add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++){
            sb.append(map.get(uf.find(i)).poll());
        }
        return sb.toString();
    }

    private class UF {
        int[] rank;
        int[] parent;
        UF (int n){
            rank = new int[n];
            parent = IntStream.range(0, n).toArray();
        }

        int find(int n){
            return n == parent[n]? n : (parent[n] = find(parent[n]));
        }

        void union(int a, int b){
            a = find(a);
            b = find(b);
            if (a == b)
                return;
            if (rank[a] > rank[b]){
                parent[b] = a;
            }else{
                parent[a] = b;
                if (rank[a] == rank[b]){
                    rank[b]++;
                }
            }
        }
    }
}
