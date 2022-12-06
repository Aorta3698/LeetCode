class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, k = nums.length;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] % 2 == 0){
                ans[i++] = nums[j];
            }else{
                ans[--k] = nums[j];
            }
        }
        return ans;
    }
}
