class Solution {
    public int subsetXORSum(int[] nums) {
        return gen(nums, 0, 0);
    }

    private int gen(int[] nums, int count, int xorSum){
        if (count == nums.length) return xorSum;

        return gen(nums, count + 1, xorSum)
        + gen(nums, count + 1, xorSum ^ nums[count]);
    }
}
