class Solution {
    public int numWays(int n, int k) {
        //let f[n][0] be ways of no last repeating and f[n][1] be ways of 1 last repeating.
        //f[n][0] = f[n-1][1]*(k-1) + f[n-1][0]*(k-1)
        //f[n][1] = f[n-1][0]
        int[][] dp = new int[n][2];
        dp[0][0] = k;
        for (int i = 1; i < dp.length; i++){
            dp[i][0] = dp[i-1][1]*(k-1) + dp[i-1][0]*(k-1);
            dp[i][1] = dp[i-1][0];
        }

        return dp[n-1][0] + dp[n-1][1];
    }
}
