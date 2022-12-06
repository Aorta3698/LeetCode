class Solution {
    public int cherryPickup(int[][] grid) {
        // int n = grid.length, m = grid[0].length;
        // int[][][] dp = new int[n][m][m];
        // for (int i = 0; i < n; i++)
        //     for (int j = 0; j < m; j++)
        //         for (int w = 0; w < m; w++)
        //             dp[i][j][w] = -1;

        // dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        // if (m == 1) dp[0][0][m - 1] -= grid[0][0];

        // int ans = 0;
        // for (int i = 1; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         for (int w = 0; w < m; w++){
        //             int max = -1;
        //             for (int o = -1; o <= 1; o++){
        //                 if (o + j < 0 || o + j >= m) continue;
        //                 for (int p = -1; p <= 1; p++){
        //                     if (w + p < 0 || w + p >= m || dp[i - 1][o + j][p + w] < 0) continue;
        //                     max = Math.max(dp[i - 1][o + j][p + w], max);
        //                 }
        //             }
        //             if (max < 0) continue;

        //             dp[i][j][w] = max + grid[i][j] + grid[i][w];
        //             if (j == w) dp[i][j][w] -= grid[i][j];
        //             ans = Math.max(dp[i][j][w], ans);
        //         }
        //     }
        // }

        // return ans;

        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int i = n - 1; i >= 0; i--){
            for (int j = 0; j < m; j++){
                for (int w = 0; w < m; w++){
                    if (i == n - 1){
                        dp[i][j][w] = grid[i][j] + grid[i][w];
                        if (j == w) dp[i][j][w] -= grid[i][j];
                        continue;
                    }

                    int max = 0;
                    for (int o = -1; o <= 1; o++){
                        for (int p = -1; p <= 1; p++){
                            if (o + j < 0 || o + j >= m || w + p < 0 || w + p >= m) continue;
                            max = Math.max(dp[i + 1][o + j][p + w], max);
                        }
                    }

                    dp[i][j][w] = max + grid[i][j] + grid[i][w];
                    if (w == j) dp[i][j][w] -= grid[i][j];
                }
            }
        }

        return dp[0][0][m - 1];
    }
}
