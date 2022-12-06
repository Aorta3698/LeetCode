class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[] dp = new double[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = i; j >= 0; j--){
                if (j == 0){
                    dp[j] *= (1 - prob[i - 1]);
                }else{
                    dp[j] = dp[j - 1] * prob[i - 1] + dp[j] * (1 - prob[i - 1]);
                }
            }
        }

        return dp[target];
    }
}

// class Solution {
//     public double probabilityOfHeads(double[] prob, int target) {
//         int n = prob.length;
//         double[][] dp = new double[n + 1][n + 1];
//         dp[0][0] = 1;
//         for (int i = 1; i <= n; i++){
//             for (int j = 0; j <= i; j++){
//                 if (j == 0){
//                     dp[i][j] = dp[i - 1][j] * (1 - prob[i - 1]);
//                 }else{
//                     dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
//                 }
//             }
//         }

//         return dp[n][target];
//     }
// }
