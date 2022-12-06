class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] seen = new boolean[m][n];
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> {
            return grid[b[0]][b[1]] - grid[a[0]][a[1]];
        });
        maxheap.offer(new int[]{0, 0});
        int ans = Integer.MAX_VALUE;
        while(!maxheap.isEmpty()){
            int[] cur = maxheap.poll();
            int x = cur[0];
            int y = cur[1];
            ans = Math.min(grid[x][y], ans);
            seen[x][y] = true;
            if (x + y == m + n - 2) break;
            for (int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || seen[nx][ny]) continue;
                maxheap.offer(new int[]{nx, ny});
            }
        }

        return ans;
    }
}
