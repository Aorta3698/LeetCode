class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int max = nums[0];

        for (int n : nums){
            curMax = Math.max(n, curMax + n);
            max = Math.max(max, curMax);
        }

        return max;
    }
}
