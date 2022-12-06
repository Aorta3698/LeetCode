class Solution {
    public int minCost(int[][] costs) {
        //dp[n][0] = min(dp[n-1][1], dp[n-1][2]);
        //dp[n][1] = min(dp[n-1][2], dp[n-1][0]);
        //dp[n][2] = min(dp[n-1][0], dp[n-1][1]);
        //we can use costs array as our dp array.

        for (int i = 1; i < costs.length; i++)
            for (int j = 0; j < 3; j++)
                costs[i][j] += Math.min(costs[i - 1][(j + 1) % 3], costs[i - 1][(j + 2) % 3]);

        return Arrays.stream(costs[costs.length - 1]).min().getAsInt();

    }
}
