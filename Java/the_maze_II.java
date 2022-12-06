class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});

        int min = Integer.MAX_VALUE;
        int[][] best = new int[maze.length][maze[0].length];
        for (int[] i : best) Arrays.fill(i, Integer.MAX_VALUE);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int step = cur[2];
            if (r == destination[0] && c == destination[1]) min = Math.min(step, min);
            for (int[] d : dirs){
                int nr = r;
                int nc = c;
                int nStep = step;
                while(nr+d[0] >= 0 && nr+d[0] < maze.length && nc+d[1] >= 0 && nc+d[1] < maze[0].length
                        && maze[nr+d[0]][nc+d[1]] != 1){
                    nr += d[0];
                    nc += d[1];
                    nStep++;
                }

                if (nr == r && nc == c) continue;
                if (nStep >= best[nr][nc]) continue;
                best[nr][nc] = nStep;
                queue.offer(new int[]{nr, nc, nStep});
            }
        }

        return min == Integer.MAX_VALUE? -1 : min;
    }
}
