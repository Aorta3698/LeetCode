class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, count = 0;
        int[] cMax = new int[n], rMax = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                rMax[i] = Math.max(grid[i][j], rMax[i]);
                cMax[j] = Math.max(grid[i][j], cMax[j]);
                count += grid[i][j] == 0? 0 : 1;
            }
        }

        return count + Arrays.stream(rMax).sum() + Arrays.stream(cMax).sum();
    }
}
