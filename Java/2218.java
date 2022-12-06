https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/discuss/1890712/Java-or-1D-or-2D-Bottom-Up-DP
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[] dp = new int[k + 1];
        for (int i = 1; i <= n; i++){
            for (int j = k; j >= 1; j--){
                int sum = 0;
                List<Integer> cur = piles.get(i-1);
                for (int m = 0; m < Math.min(j, cur.size()); m++){
                    sum += cur.get(m);
                    dp[j] = Math.max(dp[j], sum + dp[j - m - 1]);
                }
            }
        }

        return dp[k];
    }
}

// 2D DP SOLUTION IS BELOW

// class Solution {
//     public int maxValueOfCoins(List<List<Integer>> piles, int k) {
//         int n = piles.size();
//         int[][] dp = new int[n + 1][k + 1];
//         for (int i = 1; i <= n; i++){
//             for (int j = 1; j <= k; j++){
//                 List<Integer> cur = piles.get(i-1);
//                 int sum = 0;
//                 dp[i][j] = dp[i - 1][j];
//                 for (int m = 0; m < Math.min(j, cur.size()); m++){
//                     sum += cur.get(m);
//                     dp[i][j] = Math.max(dp[i][j], sum + dp[i - 1][j - m - 1]);
//                 }
//             }
//         }

//         return dp[n][k];
//     }
// }
