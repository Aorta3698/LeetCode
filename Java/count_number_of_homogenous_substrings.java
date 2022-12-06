class Solution {
    private static final int M = (int)1e9 + 7;
    public int countHomogenous(String s) {
        long[] dp = new long[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i - 1)) dp[i] += (dp[i - 1] + 1);
            else dp[i] = 1;
        }

        return (int)(Arrays.stream(dp).sum() % M);
    }
}
