class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minheap.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if (grid[x][y] < 0) continue;
            int i = 0;
            for (int[] r : dirs){
                int nx = x + r[0];
                int ny = y + r[1];
                int w = ++i == grid[x][y]? 0 : 1;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] < 0) continue;
                if (d + w < dist[nx][ny]){
                    dist[nx][ny] = d + w;
                    minheap.offer(new int[]{nx, ny, d + w});
                }
            }
            grid[x][y] *= -1;
        }

        return dist[n - 1][m - 1];
    }
}
