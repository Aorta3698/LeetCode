https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/discuss/1990345/Java-or-Concise-UnionFind
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        UF uf = new UF(source.length);
        for (int[] a : allowedSwaps){
            uf.union(a[0], a[1]);
        }
        for (int i = 0; i < source.length; i++){
            map.computeIfAbsent(uf.find(i), o -> new HashMap<>()).merge(source[i], 1, Integer::sum);
            map.get(uf.find(i)).merge(target[i], -1, Integer::sum);
        }
        int ans = 0;
        for (Map<Integer, Integer> cntMap : map.values()){
            for (int val : cntMap.values()){
                ans += Math.max(0, val);
            }
        }
        return ans;
    }

    private class UF {
        int[] rank;
        int[] parent;
        UF (int n){
            rank = new int[n];
            parent = IntStream.range(0, n).toArray();
        }

        private int find(int n){
            return n == parent[n]? n : (parent[n] = find(parent[n]));
        }

        private void union(int a, int b){
            a = find(a);
            b = find(b);
            if (a == b)
                return;
            if (rank[a] < rank[b]){
                parent[a] = b;
            }else{
                parent[b] = a;
                if (rank[a] == rank[b]){
                    rank[a]++;
                }
            }
        }
    }
}
