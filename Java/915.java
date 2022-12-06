class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--){
            min[i] = i == nums.length - 1? nums[i] : Math.min(nums[i], min[i + 1]);
        }
        for (int i = 1, max = nums[0]; true; i++){
            if (min[i] >= max)
                return i;
            max = Math.max(max, nums[i]);
        }
    }
}
