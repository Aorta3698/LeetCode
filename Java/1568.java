class Solution {
    int time = 0;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minDays(int[][] grid) {
        int num = 0, m = grid.length, n = grid[0].length, one = 0;
        int[][] order = new int[m][n], low = new int[m][n];
        boolean arti = false;
        for (int i = 0; i < m && num <= 1; i++){
            for (int j = 0; j < n && num <= 1; j++){
                one += grid[i][j];
                if (grid[i][j] == 1 && order[i][j] == 0){
                    num++;
                    arti = dfs(grid, i, j, -1, -1, order, low);
                }
            }
        }

        if (one == 1) return 1;
        if (num == 0 || num == 2) return 0;
        return arti? 1 : 2;
    }

    private boolean dfs(int[][] grid, int r, int c, int pr, int pc, int[][] order, int[][] low){
        order[r][c] = low[r][c] = ++time;
        int children = 0;
        boolean ans = false;

        for (int[] d : dirs){
            int nr = d[0] + r;
            int nc = d[1] + c;
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length
                    || grid[nr][nc] == 0 || nr == pr && nc == pc) {
                continue;
            }
            if (order[nr][nc] > 0){
                low[r][c] = Math.min(low[r][c], order[nr][nc]);
            }else{
                children++;
                if (dfs(grid, nr, nc, r, c, order, low)){
                    ans = true;
                }
                low[r][c] = Math.min(low[r][c], low[nr][nc]);
                if (pr + pc >= 0 && low[nr][nc] >= order[r][c]){
                    ans = true;
                }
            }
        }

        if (pr + pc < 0 && children >= 2){
            ans = true;
        }

        return ans;
    }
}
