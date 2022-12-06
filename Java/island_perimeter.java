class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return getPerm(seen, grid, i, j);
        }

        return 0;
    }

    private int getPerm(boolean[][] seen, int[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == 0){
            return 1;
        }

        if (seen[r][c]) return 0;

        seen[r][c] = true;

        return getPerm(seen, grid, r + 1, c) + getPerm(seen, grid, r - 1, c) +
             + getPerm(seen, grid, r, c + 1) + getPerm(seen, grid, r, c - 1);
    }
}
