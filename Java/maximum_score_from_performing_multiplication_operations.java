class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        //f(n) = Max(first * multipliers[i] + f(n-1), last * mul[i] + f(n-1))
        int[] dp = new int[multipliers.length + 1];
        for (int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[0] + )
        }
    }
}
