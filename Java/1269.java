class Solution {
    public int numWays(int steps, int arrLen) {
        int w = Math.min(500, arrLen), M = (int)1e9+7;
        int[][] dp = new int[steps+1][w];
        dp[0][0]=1;
        for (int i = 1; i <= steps; i++){
            for (int j = 0; j < w; j++){
                if (j>0){
                    dp[i][j]+=dp[i-1][j-1];
                    dp[i][j]%=M;
                }
                dp[i][j]+=dp[i-1][j];
                dp[i][j]%=M;
                if (j < w-1){
                    dp[i][j]+=dp[i-1][j+1];
                    dp[i][j]%=M;
                }
            }
        }
        return dp[steps][0];
    }
}
