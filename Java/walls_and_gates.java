class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int row = rooms.length;
        int col = rooms[0].length;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (rooms[i][j]==0)
                    queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] d : dirs){
                int x = cell[0]+d[0];
                int y = cell[1]+d[1];
                if (x < 0 || x == row || y < 0||y==col
                        ||rooms[x][y]<=rooms[cell[0]][cell[1]]+1)
                    continue;

                rooms[x][y] = rooms[cell[0]][cell[1]]+1;
                queue.offer(new int[]{x,y});
            }
        }
    }
}
