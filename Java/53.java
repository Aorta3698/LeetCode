class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int n : nums){
            sum = Math.max(n, sum + n);
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
