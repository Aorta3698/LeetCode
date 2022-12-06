class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int ans = 0;
        int[][] grid = new int[m][n];
        for (int[] g : guards){
            grid[g[0]][g[1]] = 1;
        }
        for (int[] w : walls){
            grid[w[0]][w[1]] = -1;
        }
        for (int i = 0; i < 4; i++){
            grid = rotate(grid);
            solve(grid);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void solve(int[][] grid){
        boolean mark = false;
        for (int i = 0; i < grid.length; i++, mark = false){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    mark = true;
                }
                if (grid[i][j] == 0 && mark){
                    grid[i][j] = 2;
                }
                if (grid[i][j] == -1){
                    mark = false;
                }
            }
        }
    }

    private int[][] rotate(int[][] grid){
        int[][] next = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                next[j][grid.length - 1 - i] = grid[i][j];
            }
        }
        return next;
    }
}
