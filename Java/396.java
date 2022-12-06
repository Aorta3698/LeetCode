class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, score = 0, n = nums.length;
        for (int i = 0; i < n; i++){
            score += i * nums[i];
            sum += nums[i];
        }

        int ans = score;
        for (int i = 1; i < n; i++){
            score = score - (n - 1) * nums[n - i] + sum - nums[n - i];
            ans = Math.max(ans, score);
        }

        return ans;
    }
}
