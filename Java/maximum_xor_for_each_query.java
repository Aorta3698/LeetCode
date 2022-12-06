class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int m = (1 << maximumBit) - 1;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++)
            tmp ^= nums[i];

        for (int i = nums.length - 1; i >= 0; i--){
            ans[ans.length - 1 - i] = tmp ^ m;
            tmp ^= nums[i];
        }

        return ans;
    }
}
