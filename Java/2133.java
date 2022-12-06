https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/discuss/1688876/Java-One-Pass-Solution
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[][] row = new int[n][n + 1];
        int[][] col = new int[n][n + 1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int v = matrix[i][j];
                if (++row[i][v] == 2) return false;
                if (++col[j][v] == 2) return false;
            }
        }

        return true;
    }
}
