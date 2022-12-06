class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] != 0)
                    max = Math.max(max, seek(grid, i, j));
            }
        }

        return max;
    }

    private int seek(int[][] grid, int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        return seek(grid, r+1, c) + seek(grid, r-1, c) + seek(grid, r, c + 1)
            + seek(grid, r, c - 1) + 1;
    }
}
