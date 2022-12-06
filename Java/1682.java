https://leetcode.com/problems/longest-palindromic-subsequence-ii/discuss/1670428/Java-2d-DP-with-Comments-2-solutions.
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), base = 251;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--){
            for (int j = i + 1; j <= n; j++){
                int prev = dp[i + 1][j - 1] / base;
                if (s.charAt(i - 1) == s.charAt(j - 1) && s.charAt(j - 1) != prev){
                    dp[i][j] = dp[i + 1][j - 1] % base + 2 + s.charAt(j - 1) * base;
                }
                else{
                    if (dp[i + 1][j] % base > dp[i][j - 1] % base){
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[1][n] % base;

        // int n = s.length();
        // int[][] dp = new int[n + 2][n + 2];
        // int[][] prev = new int[n + 2][n + 2];
        // for (int i = n; i >= 1; i--){
        //     for (int j = i + 1; j <= n; j++){
        //         if (s.charAt(i - 1) == s.charAt(j - 1) && s.charAt(j - 1) != prev[i + 1][j - 1]){
        //             dp[i][j] = dp[i + 1][j - 1] + 2;
        //             prev[i][j] = s.charAt(j - 1);
        //         }
        //         else{
        //             if (dp[i + 1][j] > dp[i][j - 1]){
        //                 dp[i][j] = dp[i + 1][j];
        //                 prev[i][j] = prev[i + 1][j];
        //             }else{
        //                 dp[i][j] = dp[i][j - 1];
        //                 prev[i][j] = prev[i][j - 1];
        //             }
        //         }
        //     }
        // }

        // if (s.equals("jjjvj")){
        //     for (int[] d : dp){
        //         System.out.println(Arrays.toString(d));
        //     }
        // }

        // return dp[1][n];
    }
}
