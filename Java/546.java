https://leetcode.com/problems/remove-boxes/discuss/2339470/Java-or-Bottom-up-DP-or-4-for-loop
class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int i = n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                for (int k = 0; k < n; k++){
                    for (int m = i; m <= j; m++){
                        if (boxes[m] == boxes[i]){
                            dp[i][j][k]=Math.max(dp[i][j][k], (m-1<i+1?0:dp[i+1][m-1][0])+(k<n-1?dp[m][j][k+1]:0));
                        }
                    }
                    dp[i][j][k]=Math.max(dp[i][j][k], (i==n-1?0:dp[i+1][j][0])+(k+1)*(k+1));
                }
            }
        }
        return dp[0][n-1][0];
    }
}

// INCORRECT BUT GOOD ATTEMPT IMO
//
// class Solution {
//     public int removeBoxes(int[] boxes) {
//         int n = boxes.length;
//         int[][] dp = new int[n][n];
//         for (int i = n-1; i >= 0; i--){
//             for (int j = i; j < n; j++){
//                 for (int k = j,cnt=0,last=0,sum=0; k >= i; k--){
//                     if (boxes[k]==boxes[j]){
//                         cnt++;
//                         if (last-1>=k+1){
//                             sum += dp[k+1][last-1];
//                         }
//                         last=k;
//                     }
//                     // if (k==n-1||boxes[k+1]!=boxes[j]&&boxes[k]==boxes[j]||k==i){
//                         dp[i][j]=Math.max((k==0?0:dp[i][k-1])+(k==n-1||last==0?0:dp[k+1][last-1])+cnt*cnt+sum, dp[i][j]);
//                     // }
//                 }
//             }
//         }
//         return dp[0][n-1];
//     }
// }
