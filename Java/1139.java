https://leetcode.com/problems/largest-1-bordered-square/discuss/1901430/Java-or-Query-Prefix-Sum
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid[0].length, m = grid.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int k = Math.min(n, m); k > 0; k--){
            for (int i = k; i <= m; i++){
                for (int j = k; j <= n; j++){
                    int out = query(i, j, i - k + 1, j - k + 1, dp);
                    int in  = query(i - 1, j - 1, i - k + 2, j - k + 2, dp);
                    if (out - in == Math.max(1, 4*k - 4)){
                        return k * k;
                    }
                }
            }
        }

        return 0;
    }

    private int query(int bx, int by, int tx, int ty, int[][] dp){
        if (tx > bx || ty > by){
            return 0;
        }
        return dp[bx][by] - dp[bx][ty - 1] - dp[tx - 1][by] + dp[tx - 1][ty - 1];
    }
}
