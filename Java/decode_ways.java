class Solution {
    public int numDecodings(String s) {
        //fn = f(n-1) where d(n-1) != 0 + f(n-2) where the d(n-1) == 1, 2
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1; //dp[0] added as a cushion so the loop takes care of checking the length
                           //of 2 substring in the very beginning.
        for (int i = 2; i < dp.length; i++){
            char prev = s.charAt(i - 2);
            char cur = s.charAt(i - 1);
            int lastTwo = 10 * (prev - '0') + (cur - '0');

            if (cur != '0') dp[i] += dp[i - 1]; //last word as 1-9 (A - I)
            if (lastTwo >= 10 && lastTwo <= 26) dp[i] += dp[i - 2]; //last word as 10 - 26 (J - Z)
        }

        return dp[s.length()];
    }
}
