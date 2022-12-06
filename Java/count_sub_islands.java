class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid1.length; i++)
            for (int j = 0; j < grid1[0].length; j++)
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j))
                    count++;

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        int r = grid1.length;
        int c = grid1[0].length;
        if (i < 0 || i >= r || j < 0 || j >= c || grid2[i][j] == 0) return true;

        boolean isSubIsland = grid1[i][j] == 1;
        grid1[i][j] = 0;
        grid2[i][j] = 0;

        isSubIsland = isSubIsland
            & dfs(grid1, grid2, i + 1, j)
            & dfs(grid1, grid2, i - 1, j)
            & dfs(grid1, grid2, i, j + 1)
            & dfs(grid1, grid2, i, j - 1);

        return isSubIsland;
    }
}
