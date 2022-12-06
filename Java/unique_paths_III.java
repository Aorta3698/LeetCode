class Solution {
    //down, right, up, left
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int ans = 0;
    int numOfSearch = 0;
    int emptySpot = 0;
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0)
                    emptySpot++;
                if (grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                    grid[i][j] = -1;
                }
            }

        explore(grid, startRow, startCol);
        return ans;
    }

    private void explore(int[][] grid, int r, int c){
        for (int i = 0; i < 4; i++){
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (isValid(grid, nr, nc)){
                if (grid[nr][nc] == 2 && numOfSearch == emptySpot){ans++; return;}
                numOfSearch++;
                grid[nr][nc] = -1;
                explore(grid, nr, nc);
                grid[nr][nc] = 0;
                numOfSearch--;
            }
        }
    }

    private boolean isValid(int[][] grid, int r, int c){
        if (!withinBound(grid, r, c)) return false;
        if (grid[r][c] == 2 && numOfSearch != emptySpot || grid[r][c] == -1) return false;

        return true;
    }

    private boolean withinBound(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
