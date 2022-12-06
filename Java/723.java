class Solution {
    int m, n;
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        while(true){
            int max = 0;
            int[] col = new int[n];
            for (int i = 0; i < m; i++){
                int rowCnt = 0;
                for (int j = 0; j < n; j++){
                    int cur = Math.abs(board[i][j]);
                    int l = Math.abs(board[i][Math.max(0, j - 1)]);
                    int u = Math.abs(board[Math.max(i - 1, 0)][j]);
                    rowCnt = cur == l? ++rowCnt : 1;
                    col[j] = cur == u? ++col[j] : 1;
                    if (board[i][j] > 0){
                        max = Math.max(rev(board, i, j, rowCnt - 1, board[i][j], 0, 1), max);
                        max = Math.max(rev(board, i, j, col[j] - 1, board[i][j], 1, 0), max);
                    }
                }
            }
            if (max < 3) return board;
            int[] idx = new int[n];
            Arrays.fill(idx, m - 1);
            for (int i = m - 1; i >= 0; i--){
                for (int j = n - 1; j >= 0; j--){
                    while(idx[j] >= 0 && board[idx[j]][j] < 0) idx[j]--;
                    board[i][j] = idx[j] < 0? 0 : board[idx[j]--][j];
                }
            }
        }
    }

    private int rev(int[][] board, int r, int c, int cnt, int val, int dx, int dy){
        if (r >= m || c >= n || Math.abs(board[r][c]) != val){
            return cnt;
        }
        if (rev(board, r + dx, c + dy, ++cnt, val, dx, dy) >= 3){
            board[r][c] = -Math.abs(board[r][c]);
            return 3;
        }
        return 0;
    }
}
