class NumMatrix {

    int[][] data;
    int n, m;
    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        data = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int add = val - sumRegion(row, col, row, col);
        for (int i = ++row; i <= n; i += i & -i)
            for (int j = col + 1; j <= m; j += j & -j)
                data[i][j] += add;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 -1, col2) + sum(row1 - 1, col1 - 1);
    }

    private int sum(int row, int col){
        int sum = 0;
        for (int i = ++row; i > 0; i -= i & -i)
            for (int j = col + 1; j > 0; j -= j & -j)
                sum += data[i][j];

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
