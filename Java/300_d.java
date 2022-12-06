class Solution {
    int m;
    int n;
    int M = (int)1e9+7;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public int countPaths(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
        long[][] dp = new long[m][n];
        long ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = (ans + dfs(i, j, 0, grid, dp))%M;
            }
        }
        return (int)ans;
    }

    private long dfs(int i, int j, int prev, int[][] grid, long[][] dp){
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j]<=prev){
            return 0;
        }
        if (dp[i][j]>0){
            return dp[i][j];
        }
        long ans = 1;
        for (int k = 0; k < 4; k++){
            ans = (ans + dfs(i+dx[k], j+dy[k], grid[i][j], grid, dp))%M;
        }
        return dp[i][j]=ans;
    }
}
