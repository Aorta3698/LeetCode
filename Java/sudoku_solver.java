class Solution {
    char[][] board;
    int r;
    int c;
    boolean isSolved = false;
    public void solveSudoku(char[][] board) {
        this.board = board;
        r = board.length;
        c = board[0].length;

        next(0, 0);
    }

    private void next(int row, int col){
        if (col >= 9){
            isSolved = true;
            return;
        }

        if (board[row][col] != '.'){
            walk(row, col);
        }else{
            for (int i = 0; i < 9; i++){
                char val = (char)('1'+i);
                if (checkValid(row, col, val)){
                    board[row][col] = val;
                    walk(row, col);
                    if (isSolved) return;
                    board[row][col] = '.';
                }
            }
        }
    }

    private void walk(int row, int col){
        if (col % 2 == 0 && row < r-1)
            next(row+1, col);
        else if (col % 2 == 1 && row > 0)
            next(row-1, col);
        else if ((col % 2 == 0 && row == r-1)
                || (col % 2 == 1 && row == 0))
            next(row, col+1);
    }

    private boolean checkValid(int row, int col, char val){
        for (int i = 0; i < r; i++)
            if (board[i][col] == val)
                return false;

        for (int i = 0; i < c; i++)
            if (board[row][i] == val)
                return false;

        for (int i = 0; i < 9; i++){
            int x = 3 * (row / 3) + i / 3;
            int y = 3 * (col / 3) + i % 3;
            if (board[x][y] == val)
                return false;
        }

        return true;
    }
}
