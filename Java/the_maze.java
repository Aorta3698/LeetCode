class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == destination[0] && c == destination[1]) return true;
            for (int[] d : dirs){
                int nr = r;
                int nc = c;
                while(nr+d[0] >= 0 && nr+d[0] < maze.length && nc+d[1] >= 0 && nc+d[1] < maze[0].length
                        && maze[nr+d[0]][nc+d[1]] != 1){
                    nr += d[0];
                    nc += d[1];
                }

                if (nr == r && nc == c || maze[nr][nc] == 2) continue;
                maze[nr][nc] = 2;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }

}
