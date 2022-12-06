class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1, lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if (sum >= k) hi--;
            else {
                ans = Math.max(sum, ans);
                lo++;
            }
        }

        return ans;
    }
}
