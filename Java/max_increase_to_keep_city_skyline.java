class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                rowMax[i] = Math.max(grid[i][j], rowMax[i]);
                colMax[j] = Math.max(grid[i][j], colMax[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                ans += Math.max(Math.min(rowMax[i], colMax[j]) - grid[i][j], 0);

        return ans;
    }
}
