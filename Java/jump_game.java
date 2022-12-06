class Solution {
    public boolean canJump(int[] nums) {
        boolean stuck = false;
        int zeroPos = 0;
        for (int i = nums.length-2; i >= 0; i--){
            if (nums[i] == 0 && !stuck){
                stuck = true;
                zeroPos = i;
            }

            else if (stuck){
                stuck = nums[i] <= zeroPos - i;
            }
        }

        return !stuck;
    }
}
