
class Solution {
    public int minCostII(int[][] costs) {
        //dp[n][0] = min(dp[n-1][1], dp[n-1][2], ...);
        //dp[n][1] = min(dp[n-1][2], dp[n-1][0], ...);
        //dp[n][2] = min(dp[n-1][0], dp[n-1][1], ...);
        //...
        //we can use costs array as our dp array.

        for (int i = 1; i < costs.length; i++)
            for (int j = 0; j < costs[0].length; j++){
                int min = Integer.MAX_VALUE;
                for (int w = 0; w < costs[0].length; w++){
                    if (w == j) continue;
                    min = Math.min(min, costs[i - 1][w]);
                }
                costs[i][j] += min;
            }

        return Arrays.stream(costs[costs.length - 1]).min().getAsInt();

    }
}
