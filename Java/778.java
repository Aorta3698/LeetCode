class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int s = cur[0];
            int x = cur[1];
            int y = cur[2];
            if (grid[x][y] < 0) continue;
            if (x + y == m + n - 2) return s;
            for (int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] < 0) continue;
                minheap.offer(new int[]{Math.max(s, grid[nx][ny]), nx, ny});
            }
            grid[x][y] = -grid[x][y] - 1;
        }

        return -1;
    }
}
