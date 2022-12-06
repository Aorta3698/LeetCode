https://leetcode.com/problems/choose-edges-to-maximize-score-in-a-tree/discuss/2441609/Java-or-2-Solutions-O(1)-Space-or-Take-or-Not-Take
class Solution {
    public long maxScore(int[][] edges) {
        int root = 0, n = edges.length;
        List<int[]>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int i = 0; i < n; i++){
            if (edges[i][0] >= 0){
                map[edges[i][0]].add(new int[]{i, edges[i][1]});
            }else{
                root = i;
            }
        }
        long[] ans = dfs(root, map); // [can take, cannot take]
        return Math.max(ans[0], ans[1]);
    }

    private long[] dfs(int cur, List<int[]>[] map){
        long skip = 0, take = 0;
        for (int[] m : map[cur]){
            long[] res = dfs(m[0], map);
            skip += res[1];
            take = Math.max(take, res[0] - res[1] + m[1]);
        }
        return new long[]{skip, take+skip};
    }
}
