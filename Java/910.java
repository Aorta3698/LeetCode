class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - k, min = nums[0] - k, ans = max - min;
        for (int i = 0; i < nums.length - 1; i++){
            min = Math.min(nums[i + 1] - k, nums[0] + k);
            max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            ans = Math.min(max - min, ans);
        }
        return ans;
    }
}
