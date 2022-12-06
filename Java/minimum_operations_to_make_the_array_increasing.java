class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++){
            int d = nums[i - 1] - nums[i] + 1;
            if (d <= 0) continue;
            nums[i] += d;
            ans += d;
        }

        return ans;
    }
}
