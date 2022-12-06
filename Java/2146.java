https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/discuss/1710855/java-bfs-80ms-with-comments
class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>(List.of(start));
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int VISITED = (int)1e5 + 1, n = grid.length, m = grid[0].length;

        Comparator<List<Integer>> cmp = (a, b) -> {
            int ax = a.get(0), bx = b.get(0);
            int ay = a.get(1), by = b.get(1);
            int ap = grid[ax][ay], bp = grid[bx][by];

            if (ap != bp) return ap - bp;
            if (ax != bx) return ax - bx;
            return ay - by;
        };

        while(k > 0 && !queue.isEmpty()){
            int sz = queue.size();
            List<List<Integer>> layer = new ArrayList<>();

            while(--sz >= 0){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] <= 0) continue;
                if (canTake(grid, pricing, x, y)) layer.add(List.of(x, y));
                grid[x][y] -= VISITED;
                for (int[] d : dirs){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    queue.offer(new int[]{nx, ny});
                }
            }

            layer.sort(cmp);
            for (int i = 0; i < Math.min(k, layer.size()); i++)
                ans.add(layer.get(i));
            k -= layer.size();
        }

        return ans;
    }

    private boolean canTake(int[][] grid, int[] price, int x, int y){
        return grid[x][y] != 1 && grid[x][y] >= price[0] && grid[x][y] <= price[1];
    }
}
