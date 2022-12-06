class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i]=grid[0][i];
        }
        for (int i = 1; i < m; i++){
            int[] next = new int[n];
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    next[j]=Math.min(next[j],dp[k]+grid[i][j]+moveCost[grid[i-1][k]][j]);
                }
            }
            dp=next;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
