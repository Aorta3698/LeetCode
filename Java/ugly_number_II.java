class Solution {
    public int nthUglyNumber(int n) {
        //dp[n] = min(last dp_2 * 2, last dp_3 * 3, last dp_5 * 5)
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0;
        int three = 0;
        int five = 0;

        for (int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[two] * 2, dp[three] * 3), dp[five] * 5);
            if (dp[i] % 2 == 0) two++;
            if (dp[i] % 3 == 0) three++;
            if (dp[i] % 5 == 0) five++;
        }

        return dp[n - 1];
    }
}
