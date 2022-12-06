class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A[0].length, m = A.length, ans = 0;
        for (int i = -m; i < m; i++){
            for (int j = -n; j < n; j++){
                int sum = 0;
                for (int k = 0; k < A.length; k++){
                    for (int v = 0; v < A[0].length; v++){
                        if (!ok(k + i, j + v, m, n))
                            continue;
                        if (A[k][v] == 1 && B[k + i][j + v] == 1){
                            sum++;
                        }
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    private boolean ok(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
