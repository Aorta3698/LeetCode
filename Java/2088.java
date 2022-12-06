class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] grid1 = new int[m][n];
        for (int i = 0 ; i< m; i++){
            grid1[i]=grid[i].clone();
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n-1; j++){
                if (grid[i][j]==1){
                    grid[i][j]=1+min(grid[i-1][j], grid[i-1][j+1], grid[i-1][j-1]);
                    ans += grid[i][j]-1;
                }
            }
        }
        for (int i = m-2; i >= 0; --i){
            for (int j = 1; j < n-1; ++j){
                if (grid1[i][j]==1){
                    grid1[i][j]=1+min(grid1[i+1][j], grid1[i+1][j-1], grid1[i+1][j+1]);
                    ans += grid1[i][j]-1;
                }
            }
        }

        return ans;
    }

    private int min(int... a){
        return Arrays.stream(a).min().getAsInt();
    }
}
