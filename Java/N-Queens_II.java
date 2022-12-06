class Solution {
    int[][] board;
    int ans = 0;

    public int totalNQueens(int n) {
        board = new int[n][n];
        genCol(0);
        return ans;
    }

    private void genCol(int curCol){
        if (curCol == board[0].length){
            ans++;
            return;
        }

        for (int i = 0; i < board.length; i++){
            if (check(board, i, curCol)){
                board[i][curCol] = 1;
                genCol(curCol+1);
                board[i][curCol] = 0;
            }
        }
    }

    private boolean check(int[][] board, int curRow, int curCol){
        int[][] dirs = {{0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        for (int[] d : dirs){
            int x = curRow;
            int y = curCol;
            while(true){
                x += d[0];
                y += d[1];

                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
                    break;

                if (board[x][y] == 1)
                    return false;
            }
        }

        return true;
    }
}
