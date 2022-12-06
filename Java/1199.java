class Solution {
    public int minBuildTime(int[] blocks, int split) {
        Arrays.sort(blocks);
        int n = blocks.length, INF = (int)1e9;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            Arrays.fill(dp[i], INF);
        }
        for (int i = 1; i <= n; i++){
            for (int j = i; j >= 1; j--){
                dp[i][j]=Math.min(Math.max(blocks[i-1], dp[i-1][j-1]), split+dp[i][Math.min(2*j, i)]);
            }
        }
        return dp[n][1];
    }
}
