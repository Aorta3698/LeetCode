class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < 4; i++){
            ans = Math.max(ans, solve(grid));
            grid = rotate(grid);
        }
        return ans;
    }

    private int solve(int[][] grid){
        int n = grid[0].length, m = grid.length, ans = 0;
        int[][] fcol = new int[m + 1][n];
        int[][] tcol = new int[m + 1][n];
        int[][] frow = new int[n + 1][m];
        int[][] trow = new int[n + 1][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int t = count(grid[i][j], 2);
                int f = count(grid[i][j], 5);
                fcol[i + 1][j] += fcol[i][j] + f;
                tcol[i + 1][j] += tcol[i][j] + t;
                frow[j + 1][i] += frow[j][i] + f;
                trow[j + 1][i] += trow[j][i] + t;
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int rowTwo = trow[j + 1][i];
                int rowFive= frow[j + 1][i];
                int colTwo = tcol[m][j] - tcol[i + 1][j];
                int colFive= fcol[m][j] - fcol[i + 1][j];
                ans = Math.max(ans, Math.min(rowTwo + colTwo, rowFive + colFive));
            }
        }

        return ans;
    }

    private int count(int n, int w){
        int count = 0;
        while(n % w == 0){
            count++;
            n /= w;
        }
        return count;
    }

    private int[][] rotate(int[][] grid){
        int n = grid[0].length, m = grid.length;
        int[][] next = new int[n][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                next[j][m - 1 - i] = grid[i][j];
            }
        }
        return next;
    }
}
