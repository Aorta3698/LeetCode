class Solution {
    public int minimumOperations(int[] nums) {
        int j = 0;
        while(true){
            int min = 1000;
            for (int i = 0; i < nums.length; i++){
                if (nums[i]>0){
                    min=Math.min(min, nums[i]);
                }
            }
            if (min == 1000){
                return j;
            }
            for (int i = 0; i < nums.length; i++){
                if (nums[i]>0){
                    nums[i]-=min;
                }
            }
            j++;
        }
    }
}
