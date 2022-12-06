class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int x = matrix.length-1;
        int y = 0;

        while(x < matrix.length && x >= 0 && y < matrix[0].length && y >= 0){
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                y++;
            else
                x--;
        }

        return false;

        // return search(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }

    // private boolean search(int[][] matrix,
    //         int rowS, int rowE, int colS, int colE, int target){

    //     int rMid = (rowS+rowE)/2;
    //     int cMid = (colS+colE)/2;

    //     for (int i = colS; i <= colE; i++)
    //         if (matrix[rMid][i] == target)
    //             return true;

    //     for (int i = rowS; i <= rowE; i++)
    //         if (matrix[i][cMid] == target)
    //             return true;

    //     if (matrix[rMid][cMid] == target)
    //         return true;
    //     else if (rowS >= rowE && colS >= colE)
    //         return false;
    //     else if (matrix[rMid][cMid] > target){
    //         return search(matrix, rowS, rMid-1, colS, cMid-1, target)
    //             || search(matrix, rowS, rMid-1, cMid+1, colE, target)
    //             || search(matrix, rMid+1, rowE, colS, cMid-1, target);
    //     }else{
    //         return search(matrix, rMid+1, rowE, colS, cMid-1, target)
    //             || search(matrix, rMid+1, rowE, cMid+1, colE, target)
    //             || search(matrix, rowS, rMid-1, cMid+1, colE, target);
    //     }
    // }
}
