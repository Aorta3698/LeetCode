class Solution {
    public int maxProfit(int[] prices) {
        //1 -> hold, 0 -> not hold
        //dp[n][1] = max(dp[n-1][1], dp[n-2][0]-prices[i])
        //dp[n][0] = max(dp[n-1][0], dp[n-1][1]+prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][1] = Math.max(dp[i - 1][1], dp[Math.max(i - 2, 0)][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }

        return dp[dp.length - 1][0];
    }
}
