class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= 2; j++){
                if (j == 1){
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j] = 1000;
                for (int k = 1; k <= i; k++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
            }
        }

        return dp[n][2];
    }
}
