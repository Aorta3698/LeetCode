class Solution {
    private static int R;
    private static int C;
    public int getMaximumGold(int[][] grid) {
        R = grid.length; C = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (get(grid, i, j, dirs) <= 2)
                    ans = Math.max(backtrack(grid, dirs, i, j), ans);

        return ans;
    }

    private static int backtrack(int[][] grid, int[][] dirs, int r, int c){
        int max = 0;
        grid[r][c] = -grid[r][c];
        for (int[] d : dirs){
            int x = r + d[0];
            int y = c + d[1];
            if (valid(grid, x, y)){
                max = Math.max(backtrack(grid, dirs, x, y), max);
            }
        }

        grid[r][c] = -grid[r][c];
        return max + grid[r][c];
    }

    private static int get(int[][] grid, int r, int c, int[][] dirs){
        int sum = 0;
        for (int[] d : dirs){
            int x = r + d[0];
            int y = c + d[1];
            if (valid(grid, x, y)) sum++;
        }

        return sum;
    }

    private static boolean valid(int[][] grid, int x, int y){
        return !(x < 0 || x == R || y < 0 || y == C || grid[x][y] <= 0);
    }
}
