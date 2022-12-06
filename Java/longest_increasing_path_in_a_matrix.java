class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0, r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (noLessNeighbor(matrix, matrix[i][j], i, j))
                    ans = Math.max(find(matrix, Integer.MIN_VALUE, i, j, new int[r][c]), ans);

        return ans;
    }

    private int find(int[][] grid, int prev, int r, int c, int[][] memo){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] <= prev) return 0;
        if (memo[r][c] != 0) return memo[r][c];

        int ans = 1 + Math.max(
                Math.max(find(grid, grid[r][c], r + 1, c, memo), find(grid, grid[r][c], r - 1, c, memo)),
                Math.max(find(grid, grid[r][c], r, c - 1, memo), find(grid, grid[r][c], r, c + 1, memo)));

        memo[r][c] = Math.max(ans, memo[r][c]);
        return ans;
    }

    private boolean noLessNeighbor(int[][] grid, int cur, int r, int c){
        if (r > 0 && grid[r-1][c] < cur) return false;
        if (r < grid.length - 1 && grid[r+1][c] < cur) return false;
        if (c > 0 && grid[r][c-1] < cur) return false;
        if (c < grid[0].length - 1 && grid[r][c+1] < cur) return false;
        return true;
    }
}
