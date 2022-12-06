class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] ans = new int[N][M];
        int[][] rowSum = new int[N][M];

        for (int i = 0; i < M; i++)
            for (int j = 0; j <= Math.min(k, N - 1); j++)
                rowSum[0][i] += mat[j][i];

        for (int i = 1; i < N; i++){
            for (int j = 0; j < M; j++){
                if (i + k < N) rowSum[i][j] += mat[i + k][j];
                if (i - k > 0) rowSum[i][j] -= mat[i - k - 1][j];
                rowSum[i][j] += rowSum[i - 1][j];
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j <= Math.min(M - 1, k); j++)
                ans[i][0] += rowSum[i][j];

        for (int i = 0; i < N; i++){
            for (int j = 1; j < M; j++){
                if (j + k < M) ans[i][j] += rowSum[i][j + k];
                if (j - k > 0) ans[i][j] -= rowSum[i][j - k - 1];
                ans[i][j] += ans[i][j - 1];
            }
        }

        return ans;
    }
}
