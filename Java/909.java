https://leetcode.com/problems/snakes-and-ladders/discuss/1995890/Transform-The-Board-First-then-BFS
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, ans = 0;
        board = flip(board);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int x = queue.peek()[0];
                int y = queue.poll()[1];
                if (x + y == n + n - 2)
                    return ans;
                for (int i = 1; i <= 6; i++){
                    int next = x * n + y + i;
                    if (next >= n * n)
                        break;
                    int a = next / n, b = next % n;
                    if (board[a][b] > -1){
                        int t = board[a][b] - 1;
                        a = t / n;
                        b = t % n;
                    }
                    if (!seen[a][b]){
                        queue.offer(new int[]{a, b});
                        seen[a][b] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private int[][] flip(int[][] board){
        int n = board.length;
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                next[i][i % 2 == 0? j : n - 1 - j] = board[n - i - 1][j];
            }
        }
        return next;
    }
}
