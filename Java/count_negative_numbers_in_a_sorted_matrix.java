class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int idx = 0;
        for (int row = grid.length - 1; row >= 0; row--){
            while(idx != grid[0].length && grid[row][idx] >= 0) idx++;
            if (idx == grid[0].length) break;
            count += grid[0].length - idx;
        }

        return count;
    }
}
