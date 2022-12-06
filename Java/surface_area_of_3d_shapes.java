class Solution {
    public int surfaceArea(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i > 0) ans -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                if (j > 0) ans -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
                if (grid[i][j] > 0) ans += 2;
                ans += 4 * grid[i][j];
            }
        }

        return ans;
    }
}
