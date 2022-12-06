class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2] == nums[nums.length / 2 + 1]?
            nums[nums.length / 2] : nums[nums.length / 2 - 1];
    }
}
