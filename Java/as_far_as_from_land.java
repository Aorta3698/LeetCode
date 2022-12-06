class Solution {
    public int maxDistance(int[][] grid) {
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }else
                    grid[i][j] = 200;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] d : dir){
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                        || grid[x][y] <= grid[cell[0]][cell[1]] + 1)
                    continue;
                grid[x][y] = grid[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{x, y});
                max = Math.max(max, grid[x][y]);
            }
        }

        return max-1;
    }
}
