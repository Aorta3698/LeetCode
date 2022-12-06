class Solution {
    public int shortestPath(int[][] grid, int k) {
        int tr = grid.length - 1;
        int tc = grid[0].length - 1;

        Comparator<int[]> comp = Comparator.comparingInt(o -> o[0]);
        comp = comp.thenComparing(o -> o[2]);
        PriorityQueue<int[]> minheap = new PriorityQueue<>(comp);
        minheap.offer(new int[]{dist(0, 0, tr, tc), 0, k, 0, 0});//pri, step, k, r, c
        boolean[][][] seen = new boolean[k+1][tr+1][tc+1];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int pri = cur[0];
            int step = cur[1];
            int erase = cur[2];
            int r = cur[3];
            int c = cur[4];

            if (seen[erase][r][c]) continue;
            if (r == tr && c == tc) return step;
            if (grid[r][c] == 1) erase--;
            seen[erase][r][c] = true;

            for (int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr > tr || nc < 0 || nc > tc
                        || seen[erase][nr][nc] || (grid[nr][nc] == 1 && erase == 0))
                    continue;
                minheap.offer(new int[]{dist(nr, nc, tr, tc) + step + 1, step + 1, erase, nr, nc});
            }
        }

        return -1;
    }

    private int dist(int x, int y, int dx, int dy){
        return Math.abs(x - dx) + Math.abs(y - dy);
    }
}
