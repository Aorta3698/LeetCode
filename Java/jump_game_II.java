class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++){
            max = Math.max(max, nums[i] + i);
            if (cur <= i){
                cur = max;
                count++;
            }
        }

        return count;
    }
}
