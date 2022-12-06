class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];

        for (int i = 1; i < nums.length; i++){
            int complement = nums[i] % 3 == 0? 0 : 3 - nums[i] % 3;
            int zero = Math.max(dp[0], dp[complement] + nums[i]);
            int one  = Math.max(dp[1], dp[++complement % 3] + nums[i]);
            int two  = Math.max(dp[2], dp[++complement % 3] + nums[i]);
            dp[0] = zero;
            dp[1] = one % 3 == 1? one : dp[1];
            dp[2] = two % 3 == 2? two : dp[2];
        }

        return dp[0];
    }
}
