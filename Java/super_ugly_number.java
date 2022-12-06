class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //please refer to ugly number 2 for explanation.
        //dp[n] = min(last dp_2 * 2, last dp_3 * 3, last dp_5 * 5, ...)
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int[] count = new int[primes.length];
        dp[0] = 1;

        for (int i = 1; i < n; i++){
            for (int j = 0; j < primes.length; j++)
                dp[i] = Math.min(dp[count[j]] * primes[j], dp[i]);

            for (int j = 0; j < primes.length; j++)
                if (dp[i] % primes[j] == 0)
                    count[j]++;
        }

        return dp[n - 1];
    }
}
