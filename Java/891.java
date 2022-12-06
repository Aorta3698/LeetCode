https://leetcode.com/problems/sum-of-subsequence-widths/discuss/2357334/Java-or-Prefix-sum-or-O(nlogn)
class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, two = 1, ans = 0, M = (int)1e9+7;
        long[] pre = new long[n];
        for (int i = 0; i < n; i++){
            pre[i] = i == 0? nums[i] : nums[i] + pre[i-1];
        }
        for (int i = 1; i < n; i++){
            long g = pre[n-1] - pre[i-1];
            long l = pre[n-1-i];
            ans += two * (g-l) % M;
            ans %= M;
            two = 2*two%M;
        }
        return ans;
    }
}
