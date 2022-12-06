https://leetcode.com/problems/selling-pieces-of-wood/discuss/2172149/My-School-Homework-...-(Exactly-the-same)
class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        for (int[] p : prices){
            dp[p[0]][p[1]]=p[2];
        }
        for (int i = 1; i <= m; i++){ // height
            for (int j = 1; j <= n; j++){ // width
                for (int k = 1; k <= i; k++){ // cut height (horizontally)
                    dp[i][j]=Math.max(dp[i][j], dp[i-k][j]+dp[k][j]);
                }
                for (int k = 1; k <= j; k++){ // cut width (vertically)
                    dp[i][j]=Math.max(dp[i][j], dp[i][j-k]+dp[i][k]);
                }
            }
        }
        return dp[m][n];
    }
}
