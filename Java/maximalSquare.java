class Solution {
    public int maximalSquare(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] dp = new int[N + 1][M + 1];
        int ans = 0;

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans*ans;
    }
}
