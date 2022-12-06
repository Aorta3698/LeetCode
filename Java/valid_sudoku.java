class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] i : board){
            HashSet<Character> set = new HashSet<>();
            for (char j : i){
                if (j == '.') continue;
                if(!set.add(j))
                    return false;
            }
        }

        for (int i = 0; i < board[0].length; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == '.') continue;
                if(!set.add(board[j][i]))
                    return false;
            }
        }

        for (int a = 0; a < 3; a++){
            for (int b = 0; b < 3; b++){
                HashSet<Character> set = new HashSet<>();
                for (int i = 3*a; i < 3+3*a; i++){
                    for (int j = 3*b; j < 3+3*b; j++){
                        if(board[i][j] == '.') continue;
                        if(!set.add(board[i][j]))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
