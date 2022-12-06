class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length, m = mat[0].length;
        if (n * m != r * c) return mat;
        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                ans[i][j] = mat[(j + c * i) / m][(j + c * i) % m];

        return ans;
    }
}
