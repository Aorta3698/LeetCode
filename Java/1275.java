class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        int mark = 1;
        for (int[] m : moves){
            grid[m[0]][m[1]] = mark;
            mark = -mark;
        }

        if (check(grid,  1)) return "A";
        if (check(grid, -1)) return "B";
        return moves.length == 9? "Draw" : "Pending";
    }

    private static boolean check(int[][] grid, int mark){
        int anti = 0, diag = 0, col = 0, row = 0;
        int[] cols = new int[3], rows = new int[3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (grid[i][j] != mark) continue;
                if (i == j) diag++;
                if (i + j == 2) anti++;
                col = Math.max(++cols[j], col);
                row = Math.max(++rows[i], row);
            }
        }

        return row == 3 || col == 3 || anti == 3 || diag == 3;
    }
}
