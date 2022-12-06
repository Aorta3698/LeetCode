https://leetcode.com/problems/allocate-mailboxes/discuss/2214831/Java-or-O(1*n)-Space-and-O(knn)-Time-or-DP
class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++){
            dp[i]=dp[i-1]+houses[i]-houses[i/2];
        }
        for (int i = 0; i < k-1; i++){
            for (int j = n-1; j >= 0; j--){
                int sum = 0;
                for (int m = j; m >= 0; m--){
                    sum += houses[(m+j+1)>>1]-houses[m];
                    dp[j] = Math.min(dp[j], (m==0?0:dp[m-1])+sum);
                }
            }
        }
        return dp[n-1];
    }
}

// class Solution {
//     public int minDistance(int[] houses, int k) {
//         Arrays.sort(houses);
//         int n = houses.length;
//         int[] dp = new int[n];
//         for (int i = 1; i < n; i++){
//             dp[i]=dp[i-1]+houses[i]-houses[i/2];
//         }
//         for (int i = 0; i < k-1; i++){
//             int[] next = new int[n];
//             Arrays.fill(next, Integer.MAX_VALUE);
//             for (int j = 0; j < n; j++){
//                 int sum = 0;
//                 for (int m = j; m >= 0; m--){
//                     sum += houses[(m+j+1)>>1]-houses[m];
//                     next[j] = Math.min(next[j], (m==0?0:dp[m-1])+sum);
//                 }
//             }
//             dp=next;
//         }
//         return dp[n-1];
//     }
// }
