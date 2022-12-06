class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0], ans = 0;
        for (int n : nums){
            ans = Math.max(n - min, ans);
            min = Math.min(n, min);
        }

        return ans == 0? -1 : ans;
    }
}
