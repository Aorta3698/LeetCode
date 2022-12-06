class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights[0].length, m = heights.length, ans = 0;
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        boolean[][] seen = new boolean[m][n];
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{0, 0, 0});
        while(true){
            int x = minheap.peek()[1];
            int y = minheap.peek()[2];
            ans = Math.max(ans, minheap.poll()[0]);
            seen[x][y] = true;
            if (x + y == m + n - 2)
                return ans;
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx == m || ny == n || seen[nx][ny])
                    continue;
                minheap.offer(new int[]{Math.abs(heights[nx][ny] - heights[x][y]), nx, ny});
            }
        }
    }
}
// OR use DIJKSTRA's ALGO BELOW. IT IS FASTER

// class Solution {
//     public int minimumEffortPath(int[][] heights) {
//         int n = heights[0].length, m = heights.length;
//         int[][] dist = new int[m][n];
//         for (int[] d : dist){
//             Arrays.fill(d, Integer.MAX_VALUE);
//         }
//         dist[0][0] = 0;
//         int[] dx = new int[]{0, 0, -1, 1};
//         int[] dy = new int[]{1, -1, 0, 0};
//         PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//         minheap.offer(new int[]{0, 0, 0});
//         while(true){
//             while(minheap.peek()[0] != dist[minheap.peek()[1]][minheap.peek()[2]]){
//                 minheap.poll();
//             }
//             int x = minheap.peek()[1];
//             int y = minheap.poll()[2];
//             if (x + y == m + n - 2)
//                 return dist[x][y];
//             for (int i = 0; i < 4; i++){
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
//                 if (nx < 0 || ny < 0 || nx == m || ny == n)
//                     continue;
//                 int val = Math.max(dist[x][y], Math.abs(heights[nx][ny] - heights[x][y]));
//                 if (val < dist[nx][ny]){
//                     dist[nx][ny] = val;
//                     minheap.offer(new int[]{val, nx, ny});
//                 }
//             }
//         }
//     }
// }
