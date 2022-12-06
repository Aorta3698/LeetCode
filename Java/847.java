class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, ans = 1000;
        int[][] memo = new int[n][1 << n];
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, find(graph, i, 0, (1 << n) - 1, memo));
        }
        return ans;
    }

    private int find(int[][] graph, int cur, int key, int all, int[][] memo){
        if (memo[cur][key] > 0) return memo[cur][key];
        if (all == (key | (1 << cur))) return 0;
        int min = memo[cur][key] = 1000;
        for (int n : graph[cur]){
            min = Math.min(find(graph, n, key | (1 << cur), all, memo), min);
        }
        return memo[cur][key] = min + 1;
    }
}
