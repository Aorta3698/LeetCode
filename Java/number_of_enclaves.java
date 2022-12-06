class Solution {
    private static int N;
    private static int M;
    public int numEnclaves(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int ans = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (grid[i][j] == 1)
                    ans += Math.max(0, dfs(grid, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j){
        if (i < 0 || i == N || j < 0 || j == M) return -1000;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j)
                 + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
