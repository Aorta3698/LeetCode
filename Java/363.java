class Solution {
    public int maxSumSubmatrix(int[][] matrix, int K) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[n][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                pre[j][i] = i == 0? matrix[i][j] : matrix[i][j] + pre[j][i-1];
            }
        }
        int ans = (int)-1e9;
        for (int i = 0; i < m; i++){
            for (int j = i; j < m; j++){
                var map = new TreeSet<Integer>();
                map.add(0);
                int sum = 0;
                for (int k = 0; k < n; k++){
                    sum += pre[k][j] - (i == 0? 0 : pre[k][i-1]);
                    Integer hi = map.ceiling(sum-K);
                    if (hi != null){
                        ans = Math.max(ans, sum - hi);
                    }
                    map.add(sum);
                }
            }
        }
        return ans;
    }
}
