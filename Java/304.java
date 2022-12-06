class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        dp = matrix;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0){
                    dp[i][j] += dp[i][j - 1];
                }else if (j == 0){
                    dp[i][j] += dp[i - 1][j];
                }else{
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2] - (row1 == 0? 0 : dp[row1-1][col2])
                              - (col1 == 0? 0 : dp[row2][col1-1])
                              + (row1 == 0 || col1 == 0? 0 : dp[row1-1][col1-1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
