https://leetcode.com/problems/battleships-in-a-board/discuss/1632589/Java-or-5-Lines-or-Follow-Up-One-Pass-O(1)-Space
class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X'))
                    ans++;

        return ans;
    }
}
