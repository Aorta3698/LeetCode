class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums) max |= n;
        return gen(nums, 0, max, 0);
    }

    public int gen(int[] nums, int idx, int target, int cur){
        if (idx == nums.length) return cur == target? 1 : 0;
        return gen(nums, idx + 1, target, cur) + gen(nums, idx + 1, target, cur | nums[idx]);
    }
}
