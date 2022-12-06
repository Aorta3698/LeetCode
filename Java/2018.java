https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/discuss/1977626/Java-or-Rotate-it-3-times
class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < 3; i++){
            if (solve(board, word))
                return true;
            board = rotate(board);
        }
        return solve(board, word);
    }

    private boolean solve(char[][] board, String word){
        int m = board.length, n = board[0].length, w = word.length();
        for (int i = 0; i < m; i++){
            for (int j = 0; j <= n - w; j++){
                if (ok(board, i, j, w)){
                    for (int k = j; k < j + w; k++){
                        if (board[i][k] != ' ' && board[i][k] != word.charAt(k - j))
                            break;
                        if (k == j + w - 1)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean ok(char[][] board, int i, int j, int w){
        return board[i][j] != '#'
            && (j == 0 || board[i][j - 1] == '#')
            && (j + w == board[0].length || board[i][j + w] == '#');
    }

    private char[][] rotate(char[][] board){
        int m = board.length, n = board[0].length;
        char[][] next = new char[n][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                next[j][m - 1 - i] = board[i][j];
            }
        }
        return next;
    }
}
