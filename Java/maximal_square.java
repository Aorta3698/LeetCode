class Solution {
    public int maximalSquare(char[][] matrix) {
        //check top, left, and topleft cell.
        //If they are all the same value, increment current cell by 1

        int ans = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++){
                ans = Math.max(matrix[i][j] - '0', ans);
                if (i > 0 && j > 0 && matrix[i][j] == '1'){
                    char top = matrix[i - 1][j];
                    char left = matrix[i][j - 1];
                    char topLeft = matrix[i - 1][j - 1];

                    if (top == left && top == topLeft){
                        matrix[i][j] = (char)(top + 1);
                        ans = Math.max(matrix[i][j] - '0', ans);
                        continue;
                    }

                    if (top == '0' || left == '0') continue;

                    char len = (char)(Math.min(top, left) + 1);
                    if (topLeft >= (char)(len - 1)) matrix[i][j] = len;
                    else matrix[i][j] = (char)(len - 1);
                }
            }

        return ans*ans;
    }
}
