class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((i==j||i+j==n-1)){
                    if (grid[i][j]==0){
                        return false;
                    }
                }else if (grid[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
