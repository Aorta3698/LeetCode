class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        for (int[] ind : indices){
            for (int i = 0; i < n; i++)
                grid[ind[0]][i]++;
            for (int i = 0; i < m; i++)
                grid[i][ind[1]]++;
        }

        int ans = 0;
        for (int[] g : grid)
            for (int i : g)
                if (i % 2 == 1)
                    ans++;

        return ans;
    }
}
