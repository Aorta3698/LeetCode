class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < m + n - 1; i++){
            int r = Math.min(n - 1, m + n - 2 - i), c = Math.min(i, m - 1), prev = matrix[r][c];
            for (; r >= 0 && r < n && c >= 0 && c < m; r--, c--){
                if (matrix[r][c] != prev) return false;
                prev = matrix[r][c];
            }
        }

        return true;
    }
}
