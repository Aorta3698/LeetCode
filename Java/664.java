class Solution {
    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i = j){
            while(j < s.length() && s.charAt(j) == s.charAt(i)){
                ++j;
            }
            sb.append(s.charAt(i));
        }
        s=sb.toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (j == i){
                    dp[i][i]=1;
                    continue;
                }
                dp[i][j]=dp[i][j-1]+1;
                for (int k = j-1; k >= i; k--){
                    if (s.charAt(k)==s.charAt(j)){
                        dp[i][j]=Math.min(dp[i][j], (k==i?0:dp[i][k-1]) + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
