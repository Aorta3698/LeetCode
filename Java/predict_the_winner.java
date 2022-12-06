class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) return true;
        int[][] dp = new int[nums.length][nums.length];
        canWin(nums, 0, nums.length - 1, dp, true);

        return dp[0][nums.length - 1] >= 0;
    }

    private int canWin(int[] nums, int l, int r, int[][] dp, boolean turn){
        if (l > r) return 0;
        if (dp[l][r] != 0) return dp[l][r];

        int left = canWin(nums, l + 1, r, dp, !turn);
        int right = canWin(nums, l, r - 1, dp, !turn);

        if (turn) dp[l][r] = Math.max(right + nums[r], left + nums[l]);
        else dp[l][r] = Math.min(right - nums[r], left - nums[l]);

        return dp[l][r];
    }
}
