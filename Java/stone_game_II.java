class Solution {
    public int stoneGameII(int[] piles) {
        int sum = Arrays.stream(piles).sum();
        int[][][] dp = new int[piles.length][piles.length + 1][2];
        getMax(piles, 0, 1, dp, 0);

        return (sum + dp[0][1][0]) / 2;
    }

    private int getMax(int[] p, int start, int M, int[][][] dp, int myTurn){
        if (start >= p.length) return 0;
        if (dp[start][M][myTurn] != 0) return dp[start][M][myTurn];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < Math.min(start + 2 * M, p.length); i++){
            int x = getMax(p, i + 1, Math.max(M, i - start + 1), dp, Math.abs(myTurn - 1));
            int sum = 0;
            for (int j = start; j <= i; j++) sum += p[j];
            if (myTurn == 0) max = Math.max(sum + x, max);
            else min = Math.min(-sum + x, min);
        }

        dp[start][M][myTurn] = myTurn == 0? max : min;
        return dp[start][M][myTurn];
    }
}
