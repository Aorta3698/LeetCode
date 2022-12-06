class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, ans = 0, max = 1;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++){
            dp[i][0] = dp[i][1] = 1;

            for (int j = i; j >= 0; j--){
                if (nums[i] <= nums[j]) continue;
                if (dp[i][0] == dp[j][0] + 1) dp[i][1] += dp[j][1];
                if (dp[i][0] < dp[j][0] + 1){
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = dp[j][1];
                }
            }

            if (dp[i][0] == max) ans += dp[i][1];
            if (dp[i][0] > max){
                max = dp[i][0];
                ans = dp[i][1];
            }
        }

        return ans;
    }
}
