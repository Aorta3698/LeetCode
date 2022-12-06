class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0});
        int maxDiff = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] seen = new boolean[r][c];

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            seen[x][y] = true;
            maxDiff = Math.max(cur[2], maxDiff);
            if (x == r - 1 && y == c - 1) return maxDiff;

            for (int[] d : dirs){
                int nx = d[0] + cur[0];
                int ny = d[1] + cur[1];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c
                        || seen[nx][ny]) continue;

                queue.offer(new int[]{nx, ny, Math.abs(heights[nx][ny] - heights[x][y])});
            }
        }

        return -1;
    }
}
