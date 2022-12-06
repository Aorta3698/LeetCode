https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/discuss/2287370/Identical-to-1216-...
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i<n; i++){
            for (int j = 0; j+i<n;j++){
                if (s.charAt(j)==s.charAt(i+j)){
                    dp[j][i+j]=dp[j+1][i+j-1];
                }else{
                    dp[j][i+j]=Math.min(dp[j+1][i+j],dp[j][i+j-1])+1;
                }
            }
        }

        return dp[0][n-1]<=k;
    }
}
