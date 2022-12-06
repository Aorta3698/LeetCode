https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/1669888/Java-or-Really-Similar-to-72.-Edit-Distance
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                char one = i > 0? s1.charAt(i - 1) : 0, two = j > 0? s2.charAt(j - 1) : 0;
                if (i == 0){
                    dp[i][j] = two + (j > 0? dp[i][j - 1] : 0);
                    continue;
                }
                if (j == 0){
                    dp[i][j] = one + (i > 0? dp[i - 1][j] : 0);
                    continue;
                }
                int deletei = dp[i - 1][j] + one;
                int deletej = dp[i][j - 1] + two;
                int deleteboth = dp[i - 1][j - 1] + (one == two? 0 : one + two);
                dp[i][j] = Math.min(deleteboth, Math.min(deletei, deletej));
            }
        }

        return dp[n][m];
    }
}
