class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] time = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (time[i][j] == 0 && dfs(i, j, grid, time, 0, grid[i][j])){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] grid, int[][] time, int t, char c){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != c)
            return false;
        if (time[i][j] > 0)
            return ++t - time[i][j] >= 4;

        time[i][j] = ++t;
        return dfs(i + 1, j, grid, time, t, c)
            || dfs(i - 1, j, grid, time, t, c)
            || dfs(i, j + 1, grid, time, t, c)
            || dfs(i, j - 1, grid, time, t, c);
    }
}
