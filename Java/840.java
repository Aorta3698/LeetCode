class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0, n = grid[0].length, m = grid.length;
        for (int i = 2; i < m; i++){
            for (int j = 2; j < n; j++){
                int[][] row = new int[3][3];
                int[][] col = new int[3][3];
                int[] seen = new int[16];
                int diag = 0, anti = 0;
                for (int x = 0; x < 3; x++){
                    for (int y = 0; y < 3; y++){
                        int cur = grid[i - 2 + x][j - 2 + y];
                        row[x][y] = row[x][Math.max(0, y - 1)] + cur;
                        col[y][x] = col[y][Math.max(0, x - 1)] + cur;
                        if (x == y){
                            diag += cur;
                        }
                        if (x + y == 2){
                            anti += cur;
                        }
                        seen[cur] = 1;
                    }
                }

                int count = 0, score = 0;
                for (int k = 1; k < 10; k++){
                    count += seen[k];
                }
                for (int k = 0; k < 3; k++){
                    if (row[k][2] == 15){
                        score++;
                    }
                    if (col[k][2] == 15){
                        score++;
                    }
                }
                if (count == 9 && score == 6 && anti == 15 && diag == 15){
                    ans++;
                }
            }
        }
        return ans;
    }
}
