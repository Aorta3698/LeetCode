class TicTacToe {

    int[] rows;
    int[] cols;
    int[] diag;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = new int[2];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int d = player == 1? 1 : -1;
        if (row == col){
            diag[0] += d;
        }
        if (row + col == n - 1){
            diag[1] += d;
        }
        rows[row] += d;
        cols[col] += d;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag[0]) == n || Math.abs(diag[1]) == n){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
