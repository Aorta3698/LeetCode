https://leetcode.com/problems/maximum-product-subarray/discuss/1609027/Java-3-Cases-DP-with-detailed-explanations

class Solution {
    public int maxProduct(int[] nums) {
        int maxPos = nums[0];
        int minNeg = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++){
            int n = nums[i];

            if (n > 0) {
                maxPos = Math.max(n, maxPos * n);
                minNeg = Math.min(0, minNeg * n);
            }

            if (n < 0) {
                int nextMax = Math.max(0, minNeg * n);
                int nextMin = Math.min(n, maxPos * n);
                minNeg = nextMin;
                maxPos = nextMax;
            }

            if (n == 0) maxPos = minNeg = 0;
            ans = Math.max(ans, maxPos);
        }

        return ans;
    }
}
