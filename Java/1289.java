https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/2165038/Java-or-TC-O(n)-MC-O(1)-or-Track-2-Min-Value-Per-Row
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int amin = 0, bmin = 0;
        for (int i = 0; i < m; i++){
            int bn = -1, an = -1;
            for (int j = 0; j < n; j++){
                if (i>0){
                    grid[i][j]+=j==amin?grid[i-1][bmin]:grid[i-1][amin];
                }
                if (an==-1||grid[i][j]<grid[i][an]){
                    bn=an;
                    an=j;
                }else if (bn==-1||grid[i][j]<grid[i][bn]){
                    bn=j;
                }
            }
            amin=an;
            bmin=bn;
        }

        return grid[m-1][amin];
    }
}
