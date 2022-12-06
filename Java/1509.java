class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5)
            return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 4; i <= 3; i++){
            ans = Math.min(ans, nums[j + i] - nums[i]);
        }
        return ans;
    }
}
