class Solution {
    public int equalPairs(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        String[] rows = new String[m];
        String[] cols = new String[n];
        for (int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                sb.append(grid[i][j]);
                sb.append(',');
            }
            rows[i] = sb.toString();
        }
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++){
                sb.append(grid[j][i]);
                sb.append(',');
            }
            cols[i]=sb.toString();
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (rows[i].equals(cols[j])){
                    ans++;
                }
            }
        }
        return ans;
    }
}
