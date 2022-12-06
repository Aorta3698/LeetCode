class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        if (grid[0][0] == 0){
            queue.offer(new int[]{0, 0});
        }
        grid[0][0] = -1;
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int sz = queue.size();
            while(--sz >= 0){
                int x = queue.peek()[0];
                int y = queue.poll()[1];
                if (x + y == m + n - 2)
                    return ans;
                for (int i = 0; i < 8; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx == m || ny == n || grid[nx][ny] != 0)
                        continue;
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = -1;
                }
            }
        }
        return -1;
    }
}
