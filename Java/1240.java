class Solution {
    public int tilingRectangle(int n, int m) {
        int[][] dp = new int[m+1][n+1];
        for (int[] d : dp){
            Arrays.fill(d, m*n);
        }
        for (int i = 1; i <= Math.min(m,n); i++){
            dp[i][i]=1;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                for (int k = 1; k < j; k++){
                    dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[i][j-k]);
                }
                for (int k = 1; k < i; k++){
                    dp[i][j]=Math.min(dp[i][j], dp[k][j]+dp[i-k][j]);
                }
            }
        }
        return dp[m][n];
    }
}
