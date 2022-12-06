class Solution {
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans=Math.max(ans, dfs(i,j,grid));
            }
        }
        return ans;
    }
    private int dfs(int i, int j, int[][] grid){
        if (i<0||j<0||i==m||j==n||grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(i+1,j,grid)+dfs(i-1,j,grid)+dfs(i,j+1,grid)+dfs(i,j-1,grid);
    }
}
