class Solution {
    public int getMoneyAmount(int n) {
        //we want to find the number that minimizes the worst (maximum) outcome.

        int[][] dp = new int[n + 1][n + 1];
        return worstCase(dp, 1, n);
    }

    private int worstCase(int[][] dp, int lo, int hi){
        if (lo >= hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];

        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++){
            max = Math.max(i + worstCase(dp, lo, i - 1), i + worstCase(dp, i + 1, hi));
            ans = Math.min(ans, max);
        }

        dp[lo][hi] = ans;
        return ans;
    }
}
