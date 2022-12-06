class Solution {
    private final int M = (int)1e9 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        //dp[d][target] = sum of dp[d-1][target-1...target-f];
        if (target > d*f) return 0;

        int[][] dp = new int[d][target+1];
        for (int i = 1; i <= Math.min(f, target); i++) dp[0][i] = 1; //base case

        //d = 2, f = 10, target = 7
        for (int i = 1; i < d; i++){
            for (int j = i + 1; j <= Math.min(target, f * (i + 1)); j++){
                for (int w = 1; w <= Math.min(f, j); w++){
                    dp[i][j] = (dp[i - 1][j - w] + dp[i][j]) % M;
                }
            }
        }

        return dp[d-1][target];
    }
}
