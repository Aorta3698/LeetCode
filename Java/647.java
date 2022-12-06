class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[i][i] = true;
        for (int i = n; i >= 1; i--){
            for (int j = i + 1; j <= n; j++){
                if (s.charAt(j - 1) == s.charAt(i - 1) && (dp[i + 1][j - 1] || j - i == 1)){
                    ans++;
                    dp[i][j] = true;
                }
            }
        }

        return ans;
    }
}
