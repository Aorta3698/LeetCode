class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]
        int n = s.length();
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--){
            for (int j = i; j <= n; j++){
                if (s.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i + 1][j - 1] + (j == i? 1 : 2);
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[1][n];
    }
}
