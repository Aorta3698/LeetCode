https://leetcode.com/problems/cut-off-trees-for-golf-event/discuss/1605604/Java-A*-91-SpeedandMem-with-Explanations.
class Solution {
    private static int N;
    private static int M;
    private static final int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        N = forest.size();
        M = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (forest.get(i).get(j) > 1)
                    trees.add(new int[]{i, j, forest.get(i).get(j)});

        if (trees.size() != reachableTrees(forest, 0, 0, new boolean[N][M])) return -1;
        Collections.sort(trees, Comparator.comparingInt(o -> o[2]));

        int ans = 0;
        int idx = 0;
        int pr = 0;
        int pc = 0;
        while(idx < trees.size()){
            int tr = trees.get(idx)[0];
            int tc = trees.get(idx++)[1];
            PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            minheap.offer(new int[]{dist(pr, pc, tr, tc), 0, pr, pc}); // priority, steps, r, c
            boolean[][] seen = new boolean[N][M];
            while(!minheap.isEmpty()){
                int[] cur = minheap.poll();
                int pri = cur[0];
                int steps = cur[1];
                int r = cur[2];
                int c = cur[3];
                if (r == tr && c == tc) {ans += steps; break;}
                seen[r][c] = true;

                for (int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || seen[nr][nc]
                            || forest.get(nr).get(nc) == 0)
                        continue;
                    minheap.offer(new int[]{dist(nr, nc, tr, tc) + steps + 1, steps + 1, nr, nc});
                }
            }
            pr = tr;
            pc = tc;
        }
        return ans;
    }

    private int reachableTrees(List<List<Integer>> forest, int r, int c, boolean[][] seen){
        if (r < 0 || r >= N || c < 0 || c >= M || seen[r][c]
                || forest.get(r).get(c) == 0) return 0;

        seen[r][c] = true;

        return (forest.get(r).get(c) > 1? 1 : 0)
            + reachableTrees(forest, r + 1, c, seen)
            + reachableTrees(forest, r - 1, c, seen)
            + reachableTrees(forest, r, c + 1, seen)
            + reachableTrees(forest, r, c - 1, seen);
    }

    private int dist(int x, int y, int dx, int dy){
        return Math.abs(x - dx) + Math.abs(y - dy);
    }
}
