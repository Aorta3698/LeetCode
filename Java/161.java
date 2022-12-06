class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = i;
                    continue;
                }

                int top = dp[i - 1][j] + 1;
                int left= dp[i][j - 1] + 1;
                int topleft = dp[i - 1][j - 1] + (s.charAt(i - 1) == t.charAt(j - 1)? 0 : 1);
                dp[i][j] = Math.min(Math.min(top, left), topleft);
            }
        }

        return dp[n][m] == 1;
    }
}
