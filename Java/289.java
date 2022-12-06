class Solution {
    public void gameOfLife(int[][] board) {
        int n = board[0].length, m = board.length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++){
            copy[i] = board[i].clone();
        }

        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int live = 0;
                for (int k = 0; k < 8; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0 || x == m || y == n)
                        continue;
                    live += copy[x][y];
                }
                if (copy[i][j] == 1){
                    board[i][j] = live == 2 || live == 3? 1 : 0;
                }else{
                    board[i][j] = live == 3? 1 : 0;
                }
            }
        }
    }
}
