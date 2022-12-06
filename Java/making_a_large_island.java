class Solution {
    public int largestIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int id = 1;

        List<Integer> area = new ArrayList<>(List.of(0, 0));
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    area.add(mark(grid, i, j, ++id));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 0){
                    int uID = i == 0? 0 : grid[i - 1][j];
                    int dID = i == r - 1? 0 : grid[i + 1][j];
                    int rID = j == c - 1? 0 : grid[i][j + 1];
                    int lID = j == 0? 0 : grid[i][j - 1];

                    HashSet<Integer> set = new HashSet<>();
                    int combined = 1;
                    if (set.add(uID)) combined += area.get(uID);
                    if (set.add(dID)) combined += area.get(dID);
                    if (set.add(rID)) combined += area.get(rID);
                    if (set.add(lID)) combined += area.get(lID);

                    max = Math.max(combined, max);
                }
            }
        }

        return max == 0? r*c : max;
    }

    private int mark(int[][] grid, int r, int c, int id){
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0
                || grid[r][c] == 0 || grid[r][c] == id)
            return 0;

        grid[r][c] = id;
        int area = 1 + mark(grid, r + 1, c, id)
            + mark(grid, r - 1, c, id) + mark(grid, r, c + 1, id)
            + mark(grid, r, c - 1, id);

        return area;
    }
}
