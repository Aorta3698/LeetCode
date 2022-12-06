https://leetcode.com/problems/largest-sum-of-averages/discuss/2015816/Java-or-TLE-to-Top-Down-and-Bottom-Up-DP
class Solution {
    public double largestSumOfAverages(int[] nums, int p) {
        double[] dp = new double[nums.length];
        for (int i = 0; i < p; i++){
            double[] next = new double[nums.length];
            double sum = 0;
            for (int j = 0; j < nums.length; j++){
                sum += nums[j];
                if (i == 0){
                    next[j] = sum/(j+1);
                }
                for (int k = j; k > 0 && i > 0; k--){
                    sum = k == j? nums[k] : sum+nums[k];
                    next[j] = Math.max(next[j], sum/(j-k+1)+dp[k-1]);
                }
            }
            dp = next;
        }
        return dp[nums.length - 1];
    }
}

// class Solution {
//     public double largestSumOfAverages(int[] nums, int k) {
//         return solve(0, k, nums, new double[nums.length][k+1]);
//     }

//     private double solve(int i, int lvl, int[] nums, double[][] memo){
//         if (lvl == 0)
//             return i == nums.length? 0 : -10000000;
//         if (memo[i][lvl] > 0)
//             return memo[i][lvl];

//         double ans = 0, cur = 0;
//         for (int j = i; j <= nums.length - lvl; j++){
//             cur += nums[j];
//             ans = Math.max(ans, cur/(j-i+1) + solve(j + 1, lvl - 1, nums, memo));
//         }

//         return memo[i][lvl] = ans;
//     }
// }
