class Solution {
    public int countLetters(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++)
            dp[i] = s.charAt(i) == s.charAt(i - 1)?
                1 + dp[i - 1] : 1;

        return Arrays.stream(dp).sum();
    }
}
