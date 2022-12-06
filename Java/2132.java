class Solution {
    int m, n;
    public boolean possibleToStamp(int[][] grid, int h, int w) {
        m = grid.length; n = grid[0].length;
        int[][] x = build(grid);
        int[][] ok = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (query(i, j, i+h-1, j+w-1, x) == 0){
                    ok[i][j]=1;
                }
            }
        }
        ok = build(ok);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (query(Math.max(0, i-h+1), Math.max(0, j-w+1), i, j, ok) == 0 && grid[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private int query(int i, int j, int ii, int jj, int[][] x){
        return ii >= x.length || jj >= x[0].length?
            1 :
            x[ii][jj] - (i == 0? 0 : x[i-1][jj]) - (j == 0? 0 : x[ii][j-1]) + (i*j==0? 0 : x[i-1][j-1]);
    }

    private int[][] build(int[][] grid){
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans[i][j] = (i == 0? 0 : ans[i-1][j]) + (j == 0? 0 : ans[i][j-1]) - (i*j==0? 0 : ans[i-1][j-1]) + grid[i][j];
            }
        }
        return ans;
    }
}
