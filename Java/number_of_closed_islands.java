class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0 && dfs(grid, i, j))
                    count++;

        return count;
    }

    private boolean dfs(int[][] grid, int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if (grid[r][c] == 1) return true;

        grid[r][c] = 1;

        return dfs(grid, r - 1, c) & dfs (grid, r + 1, c) & dfs (grid, r, c - 1) & dfs(grid, r, c + 1);
    }
}
