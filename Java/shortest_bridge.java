class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int r = grid.length;
        int c = grid[0].length;
        int id = 1;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    mark(grid, i, j, ++id, queue);
                }
            }
        }

        boolean[][][] seen = new boolean[id+1][r][c];
        int min = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int cID = cell[2];

                for (int[] d : dirs){
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x >= r || x < 0 || y >= c || y < 0
                            || grid[x][y] == cID || seen[cID][x][y])
                        continue;

                    seen[cID][x][y] = true;
                    if (grid[x][y] != 0) return min;
                    queue.offer(new int[]{x, y, cell[2]});
                }
            }
            min++;
        }

        return -1;
    }

    private void mark(int[][] grid, int r, int c, int id, Queue<int[]> queue){
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0
                || grid[r][c] == 0 || grid[r][c] == id)
            return;

        grid[r][c] = id;
        queue.offer(new int[]{r, c, id});
        mark(grid, r + 1, c, id, queue);
        mark(grid, r - 1, c, id, queue);
        mark(grid, r, c + 1, id, queue);
        mark(grid, r, c - 1, id, queue);
    }
}
