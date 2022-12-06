class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length;i++){
            if (nums[i] == 0){
                int end = i + 1;
                while (end < nums.length && nums[end] == 0) end++;
                if (end == nums.length) break;
                nums[i] = nums[end];
                nums[end] = 0;
            }
        }
    }
}
