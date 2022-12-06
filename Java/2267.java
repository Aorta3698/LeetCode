class Solution {
    int m;
    int n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][][] memo = new boolean[m][n][201];
        return dfs(0, 0, 0, grid, memo);
    }

    private boolean dfs(int i, int j, int bal, char[][] grid, boolean[][][] memo){
        if (i == m || j == n || memo[i][j][bal])
            return false;
        memo[i][j][bal] = true;
        bal = grid[i][j] == '('? ++bal : --bal;
        if (bal < 0)
            return false;
        if (i + j == n + m - 2)
            return bal == 0;
        return dfs(i + 1, j, bal, grid, memo)
            || dfs(i, j + 1, bal, grid, memo);
    }
}
