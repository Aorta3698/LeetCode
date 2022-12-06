class Solution {
    public int maxProfit(int k, int[] prices) {
        //dp[days][k][1] = max(dp[days-1][k][1], dp[days-1][k][0]-prices[i])
        //dp[days][k][0] = max(dp[days-1][k][0], dp[days-1][k-1][1]+prices[i])
        //we can either advance k by 1 when we buy or sell
        //advance it when we buy is easier to implmentment -> see second accepted code
        //advance it when we sell needs to check j>0 first -> see first accepted code
        //base case also is a little different with i starting at 1 and not 0 (two places).
        if (k == 0 || prices.length == 0) return 0;

        int[][][] dp = new int[prices.length][k+1][2];
        for (int i = 1; i <= k; i++) dp[0][i][1] = -prices[0];

        for (int i = 1; i < prices.length; i++){
            for (int j = 1; j <= k; j++){
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }
}
