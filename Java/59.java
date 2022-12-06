class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, j = 0, i = 0;
        while(j < n * n){
            ans[x][y] = ++j;
            int a = x + dx[i], b = y + dy[i];
            if (a == n || b == n || a < 0 || b < 0 || ans[a][b] > 0){
                i = (i + 1) % 4;
            }
            x += dx[i];
            y += dy[i];
        }
        return ans;
    }
}
