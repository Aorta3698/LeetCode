class Solution { // from j
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i){
            for (int j = i; j < n; j++){
                if (arr[i]==arr[j]&&(j-i<2)){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=dp[i][j-1]+1;
                for (int k = j-1; k >= i; k--){
                    if (arr[k] == arr[j]){
                        dp[i][j]=Math.min(dp[i][j], (k==j-1?1:dp[k+1][j-1])+(k==i?0:dp[i][k-1]));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}

// LOOP FROM i
class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i){
            for (int j = i; j < n; j++){
                if (arr[i]==arr[j]&&(j-i<2)){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=dp[i+1][j]+1;
                for (int k = i+1; k <= j; k++){
                    if (arr[k] == arr[i]){
                        dp[i][j]=Math.min(dp[i][j], (k==i+1?1:dp[i+1][k-1])+(k==j?0:dp[k+1][j]));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}


// VERSION 3
//
// class Solution {
//     public int minimumMoves(int[] arr) {
//         int n = arr.length;
//         int[][] dp = new int[n][n];
//         boolean[][] ok = new boolean[n][n];
//         for (int i = n - 1; i >= 0; --i){
//             for (int j = i; j < n; j++){
//                 ok[i][j] |= arr[i]==arr[j] && (j-i<2||ok[i+1][j-1]);
//                 if (ok[i][j]){
//                     dp[i][j]=1;
//                     continue;
//                 }
//                 dp[i][j]=dp[i+1][j]+1;
//                 for (int k = i+1; k <= j; k++){
//                     if (arr[k] == arr[i]){
//                         dp[i][j]=Math.min(dp[i][j], (k==i+1?1:dp[i+1][k-1])+(k==j?0:dp[k+1][j]));
//                     }
//                 }
//             }
//         }
//         return dp[0][n-1];
//     }
// }
