https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/discuss/2230173/Java-or-DP-or-O(MN)-or-Easier-than-Q3
class Solution {
    int m;
    int n;
    int M = (int)1e9+7;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = (ans + dfs(i, j, 0, grid, dp))%M;
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int prev, int[][] grid, int[][] dp){
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j]<=prev){
            return 0;
        }
        if (dp[i][j]>0){
            return dp[i][j];
        }
        int ans = 1;
        for (int k = 0; k < 4; k++){
            ans = (ans + dfs(i+dx[k], j+dy[k], grid[i][j], grid, dp))%M;
        }
        return dp[i][j]=ans;
    }
}
