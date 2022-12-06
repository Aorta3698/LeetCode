class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i]>=nums[i+1]){
                if (i>0&&nums[i-1]>=nums[i+1]){
                    nums[i+1]=nums[i];
                }
                if (++count>=2){
                    return false;
                }
            }
        }
        return true;
    }
}
