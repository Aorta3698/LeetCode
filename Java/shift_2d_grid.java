https://leetcode.com/problems/shift-2d-grid/discuss/1615647/Java-Easy-to-understand-Using-Modulo-Arithmetic
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length, idx = (-k + n * m * 101) % (n * m);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++){
                row.add(grid[idx / m][idx % m]);
                idx = (idx + 1) % (n * m);
            }
            ans.add(row);
        }

        return ans;
    }
}
