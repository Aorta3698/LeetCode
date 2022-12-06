//assume down[i-1] end with a, if down[i-1] not end with nums[i-1], then nums[i-1] must > a, so nums[i] > nums[i-1] > a, then up[i] = down[i-1]+1 is still valid.
https://leetcode.com/problems/wiggle-subsequence/discuss/2231511/A-few-Java-solutions-O(n)-O(n2)
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, up = 1, down = 1;

        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}

// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int n = nums.length, ans = 1;
//         int[][] dp = new int[n][2];
//         dp[0][0] = dp[0][1] = 1;

//         for (int i = 1; i < n; i++){
//             for (int j = i - 1; j >= 0; j--){
//                 if (nums[i] > nums[j]){
//                     dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
//                 }
//                 if (nums[i] < nums[j]){
//                     dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
//                 }
//             }
//             ans = Math.max(ans, Math.max(dp[i][1], dp[i][0]));
//         }

//         return ans;
//     }
// }
