class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] dp = new int[R + 1][C + 1];

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                dp[i + 1][j + 1]
                    = mat[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];

        for (int i = Math.min(R, C); i > 0; i--){
            for (int j = 0; j <= Math.min(R, C) - i; j++){
                for (int o = i; o <= Math.max(R, C); o++){
                    int row = R < C? j + i : o;
                    int col = R < C? o : j + i;
                    int sum = dp[row][col] - dp[row - i][col] - dp[row][col - i]
                        + dp[row - i][col - i];
                    if (sum <= threshold) return i;
                }
            }
        }

        return 0;
    }
}
