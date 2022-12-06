class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid[0].length, m = grid.length, p = n * m;
        int[] arr = new int[p];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr[n * i + j] = grid[i][j];
            }
        }
        for (int i = (p - k % p) % p; ans.size() < m; i = (i + n) % p){
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++){
                cur.add(arr[(i + j) % p]);
            }
            ans.add(cur);
        }
        return ans;
    }
}
