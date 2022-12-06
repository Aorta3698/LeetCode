class Solution {
    private static int R;
    private static int C;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        R = rowSum.length;
        C = colSum.length;

        int[][] ans = new int[R][C];

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (rowSum[i] == 0) break;
                int take = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = take;
                rowSum[i] -= take;
                colSum[j] -= take;
            }
        }
        return ans;
    }
}
