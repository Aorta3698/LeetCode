class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] g : grid){
            Arrays.fill(g, 1);
        }
        for (int[] m : mines){
            grid[m[0]][m[1]] = 0;
        }

        int[][] row = new int[n][n + 1];
        int[][] col = new int[n][n + 1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[j][i + 1] = col[j][i] + grid[i][j];
            }
        }

        for (int k = (n + 1)/2; k > 0; k--){
            for (int i = k - 1; i < n - (k - 1); i++){
                for (int j = k - 1; j < n - (k - 1); j++){
                    boolean lr = row[i][j + k] - row[i][j - k + 1] == 2 * k - 1;
                    boolean ud = col[j][i + k] - col[j][i - k + 1] == 2 * k - 1;
                    if (lr && ud){
                        return k;
                    }
                }
            }
        }

        return 0;
    }
}
