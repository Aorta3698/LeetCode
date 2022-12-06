class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int r = grid.length, c = grid[0].length();
        boolean[][][] visited = new boolean[1 << 6][r][c];
        int keySet = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                char ch = grid[i].charAt(j);
                if (ch >= 'a' && ch <= 'f') keySet |= (1 << (ch - 'a'));
                if (ch == '@') queue.offer(new int[]{i, j, 0});
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int keyOwn = cur[2];
                char ch = grid[x].charAt(y);
                if (visited[keyOwn][x][y]) continue;
                if (ch >= 'A' && ch <= 'F' && (keyOwn & (1 << (ch - 'A'))) == 0) continue;
                if (ch >= 'a' && ch <= 'f') keyOwn |= (1 << (ch - 'a'));
                if (keyOwn == keySet) return step;
                visited[keyOwn][x][y] = true;

                for (int[] d : dirs){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || grid[nx].charAt(ny) == '#') continue;
                    queue.offer(new int[]{nx, ny, keyOwn});
                }
            }

            step++;
        }

        return -1;
    }
}
