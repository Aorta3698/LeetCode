class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), max = 1;
        String ans = s.substring(0, 1);

        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[i][i] = true;

        for (int i = n; i >= 1; i--){
            for (int j = i + 1; j <= n; j++){
                if (s.charAt(j - 1) == s.charAt(i - 1) && (dp[i + 1][j - 1] || j - i == 1)){
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    ans = s.substring(i - 1, j);
                }
            }
        }

        return ans;
    }
}
