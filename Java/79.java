class Solution {
    private static int N;
    private static int M;
    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, new boolean[N][M]))
                    return true;
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx, boolean[][] seen){
        if (idx == word.length()) return true;
        if (r < 0 || r >= N || c < 0 || c >= M || word.charAt(idx) != board[r][c] || seen[r][c]) return false;
        seen[r][c] =  true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dirs)
            if (dfs(board, r + d[0], c + d[1], word, idx + 1, seen))
                return true;
        return seen[r][c] = false;
    }
}
