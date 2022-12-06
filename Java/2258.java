class Solution {
    int m, n;
    public int maximumMinutes(int[][] grid) {
        m = grid.length; n = grid[0].length;
        int lo = -1, hi = m*n;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            if (bfs(mid, grid))
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo == m*n? (int)1e9 : lo;
    }

    private boolean bfs(int d, int[][] grid){
        int[][] block = new int[m][n];
        Queue<int[]> fire = new ArrayDeque<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    fire.offer(new int[]{i, j});
                }
                if (grid[i][j] > 0){
                    block[i][j] = -1;
                }
            }
        }

        Queue<int[]> person = new ArrayDeque<>();
        person.offer(new int[]{0, 0});
        while(!person.isEmpty()){
            if (explore(fire, block))
                return explore(person, block);
            if (--d < 0 && explore(person, block))
                return true;
        }
        return false;
    }

    private boolean explore(Queue<int[]> queue, int[][] block){
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int j = queue.size(); j > 0; j--){
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            for (int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx == m - 1 && ny == n - 1)
                    return true;
                if (nx < 0 || ny < 0 || nx == m || ny == n || block[nx][ny] == -1)
                    continue;
                queue.offer(new int[]{nx, ny});
                block[nx][ny] = -1;
            }
        }
        return false;
    }
}
