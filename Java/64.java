class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length, INF = (int)1e9;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int a = i == 0? INF : dp[i-1][j];
                int b = j == 0? INF : dp[i][j-1];
                dp[i][j] = i+j==0? grid[i][j] : grid[i][j] + Math.min(a, b);
            }
        }
        return dp[m-1][n-1];
    }
}
