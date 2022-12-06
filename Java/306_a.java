class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int i = 1; i < n-1; i++){
            for (int j = 1; j < n-1; j++){
                for (int ii = i-1; ii <=i+1; ii++){
                    for (int jj=j-1; jj <=j+1; jj++){
                        ans[i-1][j-1]=Math.max(ans[i-1][j-1],grid[ii][jj]);
                    }
                }
            }
        }
        return ans;
    }
}
