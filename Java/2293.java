class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length > 1){
            int[] next = new int[nums.length >> 1];
            for (int i = 0; i < nums.length; i+=2){
                next[i/2]=i/2%2==0?Math.min(nums[i],nums[i+1]):Math.max(nums[i],nums[i+1]);
            }
            nums=next;
        }
        return nums[0];
    }
}
