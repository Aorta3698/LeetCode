class Solution {
    private static int R;
    private static int C;
    private final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        HashSet<Integer> cand = new HashSet<>();
        int numOfOne = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++){
                if (grid[i][j] == 1)
                    numOfOne++;
                if (grid[i][j] == 0)
                    cand.add(i * C + j);
            }

        int id = 0;
        int[][][] distGrid = new int[numOfOne][R][C];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == 1){
                    cand = bfs(grid, distGrid, i, j, id++, cand);
                    if (cand.isEmpty()) return -1;
                }

        int ans = Integer.MAX_VALUE;
        for (int p : cand){
            int step = 0;
            int r = p / C;
            int c = p % C;
            for (int i = 0; i < numOfOne; i++)
                step += distGrid[i][r][c];
            ans = Math.min(ans, step);
        }

        return ans;
    }

    private HashSet<Integer> bfs(int[][] grid, int[][][] distGrid, int x, int y, int id, HashSet<Integer> p){
        HashSet<Integer> reachable = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] seen = new boolean[R][C];

        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                if (seen[r][c]) continue;
                int pos = r * C + c;
                distGrid[id][r][c] = step;
                if (p.contains(pos)) reachable.add(pos);
                seen[r][c] = true;

                for(int[] d : dirs){
                    int nr = d[0] + r;
                    int nc = d[1] + c;
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C ||
                            seen[nr][nc] || grid[nr][nc] != 0)
                        continue;

                    queue.offer(new int[]{nr, nc});
                }
            }
            step++;
        }

        return reachable;
    }
}
