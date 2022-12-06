class Solution {
    public int longestPalindrome(String a, String b) {
        String s =a+b;
        int n = s.length(), ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i]=1;
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j+i<n; j++){
                if (s.charAt(j)==s.charAt(j+i)){
                    dp[j][i+j]=dp[j+1][i+j-1]+2;
                    if (j<a.length()&&i+j>=a.length()){
                        ans=Math.max(ans, dp[j][i+j]);
                    }
                }else{
                    dp[j][i+j]=Math.max(dp[j][i+j-1],dp[j+1][i+j]);
                }
            }
        }
        return ans;
    }
}
