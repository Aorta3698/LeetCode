https://leetcode.com/problems/cherry-pickup/discuss/1676529/Java-or-Similar-to-Today's-Daily-Cherry-Pickup-II
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                for (int w = 0; w <= n; w++)
                    dp[i][j][w] = -1;

        dp[1][1][1] = grid[0][0];
        for (int i = 1; i <= n; i++){ //first person row
            for (int j = 1; j <= n; j++){ //first person col
                for (int w = 1; w <= n; w++){ // second person row
                    int u = i + j - w;
                    if (u <= 0 || u > n) continue;
                    int one = dp[i - 1][j][w - 1];
                    int two = dp[i - 1][j][w];
                    int three = dp[i][j - 1][w - 1];
                    int four = dp[i][j - 1][w];
                    int max = Math.max(Math.max(one, two), Math.max(three, four));
                    if (max == -1 || grid[i - 1][j - 1] == -1 || grid[w - 1][u - 1] == -1) continue;

                    dp[i][j][w] = max + grid[i - 1][j - 1];
                    if (w != i && u != j) dp[i][j][w] += grid[w - 1][u - 1];
                }
            }
        }

        return Math.max(dp[n][n][n], 0);
    }
}
