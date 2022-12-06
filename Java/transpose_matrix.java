class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] ans = new int[c][r];
        for (int i = 0; i < c; i++)
            for (int j = 0; j < r; j++)
                ans[i][j] = matrix[(i * r + j) % r][(i * r + j) / r];

        return ans;
    }
}
