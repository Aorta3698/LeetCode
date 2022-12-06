class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < c; i++) dp[0][i] = matrix[0][i];

        for (int i = 1; i < r; i++){
            for (int j = 0; j < c; j++){
                int top = dp[i - 1][j];
                int tr = j == c - 1? Integer.MAX_VALUE : dp[i - 1][j + 1];
                int tl = j == 0? Integer.MAX_VALUE: dp[i - 1][j - 1];
                int min = Math.min(top, Math.min(tr, tl));
                dp[i][j] = min + matrix[i][j];
            }
        }

        return Arrays.stream(dp[r-1]).min().getAsInt();
    }
}
