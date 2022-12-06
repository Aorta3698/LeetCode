class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++){
            dp[i] = n;
            for (int j = 2; j <= i; j++){
                if (i % j == 0){
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }

        return dp[n];
    }
}
