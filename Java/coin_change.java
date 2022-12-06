class Solution {
    public int coinChange(int[] coins, int amount) {
        //f(n) = min(f(n-coins[i]) + 1)
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for (int c : coins){
                if (i - c < 0 || dp[i - c] == -1) continue;
                min = Math.min(dp[i - c] + 1, min);
            }
            dp[i] = min == Integer.MAX_VALUE? -1 : min;
        }

        return dp[amount];
    }
}
