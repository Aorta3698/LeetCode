class Solution {
    public long maximumSumScore(int[] nums) {
        long ans = Long.MIN_VALUE, pre = 0, suf = Arrays.stream(nums).asLongStream().sum();
        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            ans = Math.max(Math.max(pre, suf), ans);
            suf -= nums[i];
        }

        return ans;
    }
}
