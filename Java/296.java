class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);
        int[] chosen = new int[]{row.get(row.size()/2), col.get(col.size()/2)};
        int ans = 0;
        for (int i = 0; i < row.size(); i++){
            ans += Math.abs(row.get(i)-chosen[0])+Math.abs(col.get(i)-chosen[1]);
        }
        return ans;
    }
}
