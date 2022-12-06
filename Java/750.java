class Solution {
    public int countCornerRectangles(int[][] grid) {
        int r = grid.length, c = grid[0].length, ans = 0;
        int[] dp = new int[c * c + 1];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int w = 0; w < j; w++)
                    if (grid[i][w] == 1 && grid[i][j] == 1)
                        ans += dp[w + j * c]++;

        return ans;
    }
}
