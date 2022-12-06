class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int max = curMax;
        for (int i = 1; i < nums.length; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            max = Math.max(max, curMax);
        }

        return max;
    }
}
