class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (memo[i][j] == 0){
                    ans = Math.max(dfs(i, j, matrix, memo, -1), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] memo, int prev){
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length || matrix[i][j] <= prev)
            return 0;
        if (memo[i][j] > 0)
            return memo[i][j];
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int max = 0;
        for (int k = 0; k < 4; k++){
            max = Math.max(max, dfs(i + dx[k], j + dy[k], matrix, memo, matrix[i][j]));
        }
        return memo[i][j] = ++max;
    }
}
