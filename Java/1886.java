https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/discuss/1640861/java-based-on-48-rotate-image-space-o1
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++, rotate(mat))
            if (Arrays.deepEquals(mat, target))
                return true;

        return false;
    }

    private static void rotate(int[][] mat){
        int n = mat.length, lo = 0, hi = n - 1;
        while(lo < hi){
            for (int i = 0; i < hi - lo; i++){
                int tmp = mat[lo][i + lo];
                mat[lo][i + lo] = mat[hi - i][lo];
                mat[hi - i][lo] = mat[hi][hi - i];
                mat[hi][hi - i] = mat[i + lo][hi];
                mat[i + lo][hi] = tmp;
            }

            lo++; hi--;
        }
    }
}
