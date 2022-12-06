class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];

        // int[][] dp = new int[n+1][n+1];
        // for (int i = n; i >= 1; i--){
        //     for (int j = i; j <= n; j++){
        //         for (int k = i; k <= j; k++){
        //             dp[i][j] += (k==i?1:dp[i][k-1]) * (k==j?1:dp[k+1][j]);
        //         }
        //     }
        // }
        // return dp[1][n];
    }
}
