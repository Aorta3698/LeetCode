class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, matrix.length*matrix[0].length-1, target);
    }

    private boolean search(int[][] matrix, int start, int end, int target){
        if (start > end) return false;

        int mid = start + (end - start) / 2;
        int x = mid / matrix[0].length;
        int y = mid % matrix[0].length;
        if (matrix[x][y] == target)
            return true;
        else if (matrix[x][y] > target)
            return search(matrix, start, mid-1, target);
        else
            return search(matrix, mid+1, end, target);
    }
}
