class Solution {
    public void rotate(int[][] matrix) {
        rotateLayer(matrix, 0, matrix.length-1);
    }

    private void rotateLayer(int[][] matrix, int s, int e){
        if (s >= e) return;

        for (int i = 0; i <= e - 1 - s; i++){
            int tmp = matrix[s + i][e];
            matrix[s + i][e] = matrix[s][s + i];
            matrix[s][s + i] = matrix[e - i][s];
            matrix[e - i][s] = matrix[e][e - i];
            matrix[e][e - i] = tmp;
        }

        rotateLayer(matrix, s + 1, e - 1);
    }
}
