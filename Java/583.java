class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0){
                    dp[i][j]=dp[i][j-1]+1;
                }else if (j == 0){
                    dp[i][j]=dp[i-1][j]+1;
                }else if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                if (i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = i;
                    continue;
                }
                int deletei = dp[i - 1][j] + 1;
                int deletej = dp[i][j - 1] + 1;
                int deleteboth = dp[i - 1][j - 1] + (s1.charAt(i-1) == s2.charAt(j-1)? 0 : 2);
                dp[i][j] = Math.min(deleteboth, Math.min(deletei, deletej));
            }
        }

        return dp[n][m];
    }
}
