class Solution {
    public boolean removeOnes(int[][] grid) {
        for (int[] g : grid){
            for (int i = 0; i < g.length; i++){
                if (Math.abs(g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0]))
                    return false;
            }
        }
        return true;
    }
}
