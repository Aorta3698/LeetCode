class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int step = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cur = queue.poll();
                if (cur[0] == r-1 && cur[1] == c-1) return step;
                for (int[] d : dirs){
                    int x = d[0] + cur[0];
                    int y = d[1] + cur[1];
                    if (x < 0 || x >= r || y < 0 || y >= c
                            || grid[x][y] != 0) continue;
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }

            step++;
        }

        return -1;
    }
}
