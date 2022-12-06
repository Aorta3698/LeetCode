class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid[0].length, m = grid.length;
        int max = Math.min(n, m), ans = 1;
        int[][] rp = new int[m][n + 1];
        int[][] cp = new int[n][m + 1];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                rp[i][j + 1] = rp[i][j] + grid[i][j];
                cp[j][i + 1] = cp[j][i] + grid[i][j];
            }
        }

        for (ans = max; ans >= 2; ans--){
            for (int i = ans - 1; i < m; i++){
                for (int j = ans - 1; j < n; j++){
                    int w = 0, t = rp[i][j + 1] - rp[i][j - ans + 1], a = 0, b = 0;
                    for (; w < ans; w++){
                        if (t != rp[i - w][j + 1] - rp[i - w][j - ans + 1]){
                            break;
                        }
                        if (t != cp[j - w][i + 1] - cp[j - w][i - ans + 1]){
                            break;
                        }
                        a += grid[i - w][j - w];
                        b += grid[i - ans + 1 + w][j - w];
                    }
                    if (w == ans && a == b && a == t)
                        return ans;
                }
            }
        }

        return ans;
    }
}
