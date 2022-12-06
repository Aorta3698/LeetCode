class Solution {
    public int numDistinctIslands(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Set<Long> ans = new HashSet<>();
        // Set<List<Integer>> all = new HashSet<>();
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    // List<Integer> one = new ArrayList<>();
                    // ans.add(paint(101, grid, i, j, one));
                    ans.add(paint(101, grid, i, j));

                    // boolean add = true;
                    // for (List<Integer> cur : all) {
                    //     if (cur.size() == 1 && one.size() == 1) add = false;
                    //     if (!add) break;
                    //     if (cur.size() != one.size()) continue;

                    //     for (int a = 0; a < cur.size() - 1; a++){
                    //         int f = cur.get(a + 1) - one.get(a + 1);
                    //         int p = cur.get(a) - one.get(a);
                    //         if (f != p) break;
                    //         if (a == cur.size() - 2) add = false;
                    //     }
                    // }

                    // if (add) all.add(one);
                }
            }
        }

        return ans.size();
        //return all.size();
    }

    private long paint(long hash, int[][] grid, int x, int y){
        int r = grid.length;
        int c = grid[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c
                || grid[x][y] == 0) return 0;

        grid[x][y] = 0;

        hash += paint(11 * hash, grid, x + 1, y);
        hash += paint(23 * hash, grid, x - 1, y);
        hash += paint(43 * hash, grid, x, y - 1);
        hash += paint(53 * hash, grid, x, y + 1);

        return hash;
    }

    // private void paint(int[][] grid, int x, int y, List<Integer> id){
    //     int r = grid.length;
    //     int c = grid[0].length;
    //     if (x < 0 || x >= r || y < 0 || y >= c
    //             || grid[x][y] == 0) return;

    //     id.add(c*x+y);
    //     grid[x][y] = 0;
    //     paint(grid, x + 1, y, id);
    //     paint(grid, x - 1, y, id);
    //     paint(grid, x, y - 1, id);
    //     paint(grid, x, y + 1, id);
    // }
}
