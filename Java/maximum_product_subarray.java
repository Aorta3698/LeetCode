class Solution {
    public int maxProduct(int[] nums) {
        //0 --> max, 1 --> min
        //dp[n][0] = nums[n]*dp[n-1][0] or nums[n]dp[n-1][1];
        //dp[n][1] = nums[n]dp[n-1][1] or nums[n]dp[n-1][1];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = nums[0];

        int ans = nums[0];
        for (int i = 1; i < nums.length ;i++){
            if (nums[i] == 0){
                dp[i][0] = dp[i][1] = 0;
                ans = Math.max(ans, dp[i][0]);
                continue;
            }

            if (nums[i] > 0){
                dp[i][0] = dp[i - 1][0] > 0? nums[i] * dp[i - 1][0] : nums[i];
                dp[i][1] = dp[i - 1][1] <= 0? nums[i] * dp[i - 1][1] : nums[i];
            }

            if (nums[i] < 0){
                dp[i][0] = dp[i - 1][1] <= 0? nums[i] * dp[i - 1][1] : nums[i];
                dp[i][1] = dp[i - 1][0] > 0? nums[i] * dp[i - 1][0] : nums[i];
            }

            ans = Math.max(ans, dp[i][0]);
        }

        return ans;
    }
}
