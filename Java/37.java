class Solution {
    int[] rowUsed;
    int[] colUsed;
    int[] sqrUsed;
    public void solveSudoku(char[][] board) {
        rowUsed = new int[9];
        colUsed = new int[9];
        sqrUsed = new int[81];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    rowUsed[i] |= 1 << board[i][j] - '0';
                    colUsed[j] |= 1 << board[i][j] - '0';
                    sqrUsed[hash(i, j)] |= 1 << board[i][j] - '0';
                }
            }
        }
        solve(0, 0, board);
    }

    private int hash(int i, int j){
        return i/3*3*9+j/3*3;
    }

    private boolean solve(int r, int c, char[][] board){
        if (r == 9){ // this is the end of everything
            return true;
        }
        if (c == 9){ // this is the end of each row, solve for the next row
            return solve(r+1, 0, board);
        }
        if (board[r][c] != '.'){
            return solve(r, c+1, board);
        }
        for (int i = 1; i <= 9; i++){
            if ((colUsed[c] & 1<<i) == 0 && (rowUsed[r] & 1<<i) == 0 && (sqrUsed[hash(r, c)] & 1<<i) == 0){
                colUsed[c] ^= 1<<i;
                rowUsed[r] ^= 1<<i;
                sqrUsed[hash(r, c)] ^= 1<<i;
                board[r][c] = (char)('0' + i);
                if (solve(r, c+1, board)){
                    return true;
                }
                board[r][c] = '.';
                colUsed[c] ^= 1<<i;
                rowUsed[r] ^= 1<<i;
                sqrUsed[hash(r, c)] ^= 1<<i;
            }
        }
        return false;
    }
}
