class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int INF = (int)1e9, secMax = -INF, secMin = INF, base = 0;
        for (int i = 1, prev = nums[0]; i < nums.length; i++){
            secMax = Math.max(secMax, Math.min(prev, nums[i]));
            secMin = Math.min(secMin, Math.max(prev, nums[i]));
            base += Math.abs(nums[i] - prev);
            prev = nums[i];
        }
        int ans = base + 2 * (secMax - secMin);
        for (int i = 0; i < nums.length-1; i++){
            ans = Math.max(ans, base - Math.abs(nums[i] - nums[i+1]) + Math.abs(nums[0] - nums[i+1]));
        }
        for (int i = nums.length - 1; i > 0; i--){
            ans = Math.max(ans, base - Math.abs(nums[i] - nums[i-1]) + Math.abs(nums[nums.length-1] - nums[i-1]));
        }
        return ans;
    }
}
