/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    private final int[][] idx = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private final int N = 500;
    private int gr = -1;
    private int gc = -1;

    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[2*N+1][2*N+1];
        dfs(master, N, N, grid, new char[]{'U', 'L', 'D', 'R'}, new boolean[2*N+1][2*N+1]);
        grid[N][N] = -1;
        if (gr == -1 || gc == -1) return -1;

        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.add(new int[]{getDist(N, N, gr, gc), N, N, 0});

        int[][] best = new int[2*N+1][2*N+1];
        for (int[] b : best) Arrays.fill(b, Integer.MAX_VALUE);
        best[N][N] = getDist(N, N, gr, gc);

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int p = cur[0];
            int r = cur[1];
            int c = cur[2];
            int step = cur[3];
            if (r == gr && c == gc) return step;

            for (int[] d : idx){
                int nr = r + d[0];
                int nc = c + d[1];
                int np = getDist(nr, nc, gr, gc) + step + 1;
                if (grid[nr][nc] == 0 || best[nr][nc] <= np) continue;
                minheap.offer(new int[]{np, nr, nc, step + 1});
                best[nr][nc] = np;
            }
        }

        return -1;
    }

    private void dfs(GridMaster master, int r, int c, int[][] grid, char[] dirs, boolean[][] seen){
        if (seen[r][c]) return;
        if (master.isTarget()){
            gr = r;
            gc = c;
            grid[r][c] = 2;
        }
        else grid[r][c] = 1;

        seen[r][c] = true;

        for (int i = 0; i < 4; i++){
            char d = dirs[i];
            char o = dirs[(i + 2) % 4];
            int nr = r + idx[i][0];
            int nc = c + idx[i][1];
            if (master.canMove(d)){
                master.move(d);
                dfs(master, nr, nc, grid, dirs, seen);
                master.move(o);
            }else
                grid[nr][nc] = 0;
        }
    }

    private int getDist(int sr, int sc, int gr, int gc){
        return Math.abs(sr - gr) + Math.abs(sc - gc);
    }
}
