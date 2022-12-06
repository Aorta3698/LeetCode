https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/discuss/1924893/Java-or-91-Speed-or-Recursion
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat[0].length, m = mat.length;
        boolean[][] seen = new boolean[m][m * 70 + 1];
        dfs(0, mat, 0, seen);
        for (int i = 0; true; i++){
            for (int j = 0, sign = 1; j < 2; j++, sign *= -1){
                int k = target - i * sign;
                if (k >= 0 && k <= m * 70 && seen[m - 1][k])
                    return i;
            }
        }
    }

    private void dfs(int i, int[][] mat, int sum, boolean[][] seen){
        if (i == mat.length)
            return;

        for (int j = 0; j < mat[i].length; j++){
            if (!seen[i][sum + mat[i][j]]){
                seen[i][sum + mat[i][j]] = true;
                dfs(i + 1, mat, sum + mat[i][j], seen);
            }
        }
    }
}
