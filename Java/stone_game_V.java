class Solution {
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        int[][] dp = new int[N][N+1];

        int[] prefixSum = new int[N + 1];
        for (int i = N - 1; i >= 0; --i)
            prefixSum[i] += (prefixSum[i + 1] + stoneValue[i]);

        getMax(prefixSum, 0, N, dp);
        return dp[0][N];
    }

    private int getMax(int[] pSum, int lo, int hi, int[][] dp){
        if (lo >= hi - 1) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];

        int max = Integer.MIN_VALUE;
        for (int i = 1; lo + i < hi; i++){
            int r = pSum[lo + i] - pSum[hi];
            int l = pSum[lo] - pSum[lo + i];
            if (r > l) max = Math.max(l + getMax(pSum, lo, lo + i, dp), max);
            if (r < l) max = Math.max(r + getMax(pSum, lo + i, hi, dp), max);
            if (r == l){
                int left = getMax(pSum, lo, lo + i, dp) + r;
                int right= getMax(pSum, lo + i, hi, dp) + l;
                max = Math.max(max, Math.max(right, left));
            }
        }

        return dp[lo][hi] = max;
    }
}
