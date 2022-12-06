class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length;j++)
                if (grid[i][j]=='1'){
                    count++;
                    eliminate(grid, i, j);
                }
        return count;
    }

    private void eliminate(char[][] arr, int row, int col){
        if (row < 0 || row == arr.length || col < 0 || col == arr[0].length
                || arr[row][col]=='0')
            return;

        arr[row][col] = '0';
        eliminate(arr, row-1,col);
        eliminate(arr, row+1,col);
        eliminate(arr, row,col+1);
        eliminate(arr, row,col-1);
    }
}
