class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < max)
                return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
