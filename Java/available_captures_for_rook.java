class Solution {
    public int numRookCaptures(char[][] board) {
        int[] p = new int[2];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i][j] == 'R')
                    p = new int[]{i, j};

        int count = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dirs){
            int r = p[0] + d[0];
            int c = p[1] + d[1];
            while(r >= 0 && r < 8 && c >= 0 && c < 8){
                if (board[r][c] == 'p') {count++; break;}
                if (board[r][c] != '.') break;
                r += d[0];
                c += d[1];
            }
        }

        return count;
    }
}
