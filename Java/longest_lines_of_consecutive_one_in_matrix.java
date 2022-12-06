class Solution {
    public int longestLine(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        int[] diag = new int[r+c-1];
        int[] anti = new int[r+c-1];
        int ans = 0;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                ans = Math.max(update(mat[i][j], i, row), ans);
                ans = Math.max(update(mat[i][j], j, col), ans);
                ans = Math.max(update(mat[i][j], j - i + r - 1, diag), ans);
                ans = Math.max(update(mat[i][j], i + j, anti), ans);
            }
        }

        return ans;
    }

    private int update(int val, int idx, int[] arr){
        arr[idx] = val == 1? arr[idx] + 1 : 0;
        return arr[idx];
    }
}
