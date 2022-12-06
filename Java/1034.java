class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, color, grid[row][col], new boolean[grid.length][grid[0].length]);
        return grid;
    }

    private boolean dfs(int[][] grid, int m, int n, int color, int st, boolean[][] visited){
        if (m < 0 || n < 0 || m == grid.length || n == grid[0].length)
            return true;
        if (visited[m][n])
            return false;
        if (grid[m][n] != st)
            return true;
        visited[m][n] = true;
        if (dfs(grid, m + 1, n, color, st, visited)
          | dfs(grid, m - 1, n, color, st, visited)
          | dfs(grid, m, n + 1, color, st, visited)
          | dfs(grid, m, n - 1, color, st, visited)){
            grid[m][n] = color;
        }
        return false;
    }
}
