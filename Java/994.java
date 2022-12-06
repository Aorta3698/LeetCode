class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length, fresh = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                    grid[i][j]=-1;
                }else{
                    fresh += grid[i][j];
                }
            }
        }
        int ans = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while(!queue.isEmpty() && fresh > 0){
            for (int sz = queue.size(); sz > 0; sz--){
                int[] top = queue.poll();
                int x = top[0], y = top[1];
                for (int i = 0; i < 4; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if (nx<0||ny<0||nx==m||ny==n||grid[nx][ny]==-1)
                        continue;
                    if (grid[nx][ny]==1){
                        queue.offer(new int[]{nx,ny});
                        fresh--;
                    }
                    grid[nx][ny]=-1;
                }
            }
            ans++;
        }
        return fresh==0?ans:-1;
    }
}
