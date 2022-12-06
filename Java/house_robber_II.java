class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 2) return Arrays.stream(nums).max().getAsInt();

        //dp[n] = Max(dp[n-1], dp[n-2]+nums[n])
        int[] dp1 = new int[nums.length - 1]; //rob the first one
        int[] dp2 = new int[nums.length - 1]; //did not

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[2], nums[1]);

        for (int i = 2; i < nums.length-1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i+1]);
        }

        return Math.max(dp2[dp2.length - 1], dp1[dp1.length - 1]);
    }
}
