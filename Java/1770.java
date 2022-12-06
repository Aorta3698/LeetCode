class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = multipliers.length, ans = Integer.MIN_VALUE;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; i + j <= n; j++){
                if (i == 0 && j == 0) continue;
                int m = i + j > 0? multipliers[i + j - 1] : Integer.MIN_VALUE;
                int left = i > 0? dp[i - 1][j] + nums[i - 1] * m :Integer.MIN_VALUE;
                int right= j > 0? dp[i][j - 1] + nums[nums.length - j] * m :Integer.MIN_VALUE;
                dp[i][j] = Math.max(left, right);
                if (i + j == n) ans = Math.max(dp[i][j], ans);
            }
        }

        return ans;
    }
}
