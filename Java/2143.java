https://leetcode.com/problems/choose-numbers-from-two-arrays-in-range/discuss/2324309/Knapsack-1D-DP-or-Java-or-O(Sum-*-N)-or-Explained.
class Solution {
    public int countSubranges(int[] A, int[] B) {
        int n = A.length, Z = 100*n, ans = 0, M = (int)1e9 + 7;
        int[] dp = new int[2*Z+1];
        for (int j = 0; j < n; j++){
            dp[Z]++;
            int[] ndp = new int[dp.length];
            for (int k = 0; k < dp.length; k++){
                if (k + A[j] < dp.length){
                    ndp[k+A[j]]+=dp[k];
                    ndp[k+A[j]]%=M;
                }
                if (k - B[j] >= 0){
                    ndp[k-B[j]]+=dp[k];
                    ndp[k-B[j]]%=M;
                }
            }
            ans += ndp[Z];
            ans %= M;
            dp = ndp;
        }
        return ans;
    }
}

// class Solution {
//     public int countSubranges(int[] A, int[] B) {
//         int n = A.length, Z = 10000, ans = 0, M = (int)1e9 + 7;
//         int[][] dp = new int[n+1][20001];
//         for (int i = 0; i <= n; i++){
//             dp[i][Z]=1;
//         }
//         for (int j = 0; j < n; j++){
//             for (int k = 0; k <= 20000; k++){
//                 if (k + A[j] <= 20000){
//                     dp[j+1][k+A[j]]+=dp[j][k];
//                     dp[j+1][k+A[j]]%=M;
//                 }
//                 if (k - B[j] >= 0){
//                     dp[j+1][k-B[j]]+=dp[j][k];
//                     dp[j+1][k-B[j]]%=M;
//                 }
//             }
//             ans += dp[j+1][Z]-1;
//             ans %= M;
//         }
//         return ans;
//     }
// }
