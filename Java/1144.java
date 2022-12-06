class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(solve(0, nums.clone()), solve(1, nums));
    }

    private int solve(int st, int[] nums){
        int ans = 0;
        for (int i = st; i < nums.length; i+=2){
            if (i > 0){
                ans += Math.max(0, nums[i] - nums[i - 1] + 1);
                nums[i] = Math.min(nums[i], nums[i - 1] - 1);
            }
            if (i < nums.length - 1){
                ans += Math.max(0, nums[i] - (nums[i + 1] - 1));
                nums[i] = Math.min(nums[i], nums[i + 1] - 1);
            }
        }
        return ans;
    }
}
