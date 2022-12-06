class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi)
            ans = Math.max(nums[lo++] + nums[hi--], ans);

        return ans;
    }
}
