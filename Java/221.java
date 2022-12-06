class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    int a = i == 0? 0 : dp[i-1][j];
                    int b = j == 0? 0 : dp[i][j-1];
                    int c = i*j == 0? 0 : dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(Math.min(a, b), c);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
