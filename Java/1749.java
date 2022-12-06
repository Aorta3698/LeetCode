class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, max = 0, min = 0;
        for (int n : nums){
            max = Math.max(max + n, n);
            min = Math.min(min + n, n);
            ans = Math.max(max, ans);
            ans = Math.max(-min, ans);
        }

        return ans;
    }
}
