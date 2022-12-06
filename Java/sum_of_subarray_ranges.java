class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++){
            int max = nums[i];
            int min = max;
            for (int j = i + 1; j < nums.length; j++){
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                ans += (max - min);
            }
        }

        return ans;
    }
}
