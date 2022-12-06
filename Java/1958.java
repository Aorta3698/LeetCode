class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[] d = new int[]{1, 0, -1};
        int n = board[0].length, m = board.length;
        char op = color == 'B'? 'W' : 'B';
        for (int x : d){
            for (int y : d){
                if (x == 0 && y == 0){
                    continue;
                }
                int a = rMove + x, b = cMove + y;
                while(a < m && a >= 0 && b < n && b >= 0 && board[a][b] != '.'){
                    if (board[a][b] == color){
                        if (Math.abs(a - rMove) >= 2 || Math.abs(b - cMove) >= 2)
                            return true;
                        break;
                    }
                    a += x;
                    b += y;
                }
            }
        }

        return false;
    }
}
