class Solution {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < copy.length; i++) copy[i] = board[i].clone();

        for (int i = 0; i < copy.length; i++){
            for (int j = 0; j < copy[0].length; j++){
                int n = getNeighbors(board, i, j);
                if (copy[i][j] == 1) copy[i][j] = (n < 2 || n > 3)? 0 : 1;
                else copy[i][j] = n == 3? 1 : 0;
            }
        }

        for (int i = 0; i < copy.length; i++) board[i] = copy[i].clone();
    }

    private int getNeighbors(int[][] board, int r, int c){
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if (board[nr][nc] == 1) count++;
        }

        return count;
    }
}
