class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0){
                    col.add(j);
                    row.add(i);
                }

        for (int r : row)
            for (int i = 0; i < matrix[0].length; i++)
                matrix[r][i] = 0;

        for (int c : col)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][c] = 0;
    }
}
