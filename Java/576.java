class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int M = (int)1e9+7;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int[][] dp = new int[m][n];
        for (int r = 0; r < maxMove; r++){
            int[][] next = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    for (int k = 0; k < 4; k++){
                        int x = i+dx[k], y = j+dy[k];
                        if (x < 0 || y < 0 || x == m || y == n){
                            next[i][j]++;
                            continue;
                        }
                        next[i][j]+=dp[x][y];
                        next[i][j]%=M;
                    }
                }
            }
            dp=next;
        }
        return dp[startRow][startColumn];
    }
}
