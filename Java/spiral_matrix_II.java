class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, r = 0, c = 0, size = 1;
        ans[0][0] = size;
        while(size < n * n){
            while(valid(r + dirs[d][0], c + dirs[d][1], n, ans)){
                r += dirs[d][0];
                c += dirs[d][1];
                ans[r][c] = ++size;
            }
            d = ++d % 4;
        }

        return ans;
    }

    private static boolean valid(int r, int c, int n, int[][] ans){
        return r >= 0 && r < n && c >= 0 && c < n && ans[r][c] == 0;
    }
}
