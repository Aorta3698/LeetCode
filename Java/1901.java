https://leetcode.com/problems/find-a-peak-element-ii/discuss/1883944/Java-Binary-Search
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat[0].length, m = mat.length, lo = 0, hi = n - 1, max = 0;

        while(lo < hi){
            int mid = (lo + hi) >> 1;

            max = getMaxFromCol(mat, mid);
            if (mid == n - 1 || mat[max][mid] > mat[max][mid + 1]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return new int[]{getMaxFromCol(mat, lo), lo};

    }

    private int getMaxFromCol(int[][] mat, int mid){
        int max = 0, m = mat.length;
        for (int i = 0; i < m; i++){
            if (mat[i][mid] > mat[max][mid]){
                max = i;
            }
        }
        return max;
    }
}
