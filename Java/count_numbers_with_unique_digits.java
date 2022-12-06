class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            int base = 9;
            for (int j = 1; j < i; j++) base *= (10 - j);
            dp[i] += (dp[i - 1] + base);
        }

        return dp[n];
    }
}
