class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;

        if (queue.isEmpty()) return fresh != 0? -1 : 0;

        int [][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minute = -1;
        while(!queue.isEmpty()){
            minute++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();
                for (int[] d : dir){
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x < 0 || x >= row || y < 0 || y >= col
                            || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return fresh != 0? -1 : minute;
    }
}
