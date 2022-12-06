class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++){
            if (n % i != 0) continue;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i / 2; j >= 1; j--){
                if (i % j != 0) continue;
                dp[i] = Math.min(dp[j] + i / j, dp[i]);
            }
        }

        return dp[n];
    }
}
