class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int[][] dp = new int[stones.length][stones.length];
        getMaxDiff(stones, 0, stones.length - 1, true, sum, dp);
        return dp[0][stones.length - 1];
    }

    private int getMaxDiff(int[] stones, int l, int r, boolean myTurn, int sum, int[][] dp){
        if (l > r) return 0;
        if (dp[l][r] != 0) return dp[l][r];

        int left = getMaxDiff(stones, l + 1, r, !myTurn, sum - stones[l], dp);
        int right= getMaxDiff(stones, l, r - 1, !myTurn, sum - stones[r], dp);

        dp[l][r] = myTurn? Math.max(sum - stones[l] + left, sum - stones[r] + right) :
            Math.min(left - sum + stones[l], right - sum + stones[r]);

        return dp[l][r];
    }
}
