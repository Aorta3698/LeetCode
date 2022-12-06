https://leetcode.com/problems/sparse-matrix-multiplication/discuss/1634759/Java-or-Simple-5-Lines-or-O(NMK)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < ans.length; i++)
            for (int j = 0; j < ans[0].length; j++)
                for (int w = 0; w < mat2.length; w++)
                    ans[i][j] += mat1[i][w] * mat2[w][j];

        return ans;
    }
}
