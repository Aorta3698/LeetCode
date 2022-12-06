class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = getChar(board, 'X');
        int oCount = getChar(board, 'O');
        if (xCount < oCount || xCount > oCount + 1) return false;

        int xWinning = getWinning(board, 'X');
        int oWinning = getWinning(board, 'O');
        if ((xWinning == 1 || xWinning == 2) && xCount == oCount) return false;
        if (oWinning == 1 && xCount != oCount) return false;
        if (!(xWinning == 2 && xCount + oCount == 9) && xWinning + oWinning > 1)
            return false;

        return true;
    }

    private int getChar(String[] board, char ch){
        int count = 0;
        for (String s : board)
            for (char c : s.toCharArray())
                if (c == ch) count++;
        return count;
    }

    private int getWinning(String[] board, char ch){
        String win = String.valueOf(ch).repeat(3);
        int count = 0;
        StringBuilder[] sb = new StringBuilder[3];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        for (int i = 0; i < board.length; i++){
            if (board[i].equals(win)) count++;
            for (int j = 0; j < board[i].length(); j++)
                sb[j].append(board[i].charAt(j));
        }

        for (StringBuilder s : sb)
            if (s.toString().equals(win)) count++;

        boolean diag = true;
        boolean anti = true;
        for (int i = 0; i < board.length; i++){
            if (board[i].charAt(i) != ch) anti = false;
            if (board[i].charAt(2-i) != ch) diag = false;
        }

        if (diag) count++;
        if (anti) count++;

        return count;
    }
}
