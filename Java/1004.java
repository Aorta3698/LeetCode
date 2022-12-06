https://leetcode.com/problems/max-consecutive-ones-iii/discuss/1660587/Java-or-Shrinkable-Sliding-Window
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, one = 0, n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1) one++;
            if (ans - one < k) ans++;
            else one -= nums[i - ans];
        }

        return ans;
    }
}
