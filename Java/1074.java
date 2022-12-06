class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++){
            for (int j = 0 ; j < n; j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = i; j < m; j++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int pre = 0;
                for (int k = 0; k < n; k++){
                    pre += matrix[j][k]-(i==0?0:matrix[i-1][k]);
                    ans += map.getOrDefault(pre-target, 0);
                    map.merge(pre, 1, Integer::sum);
                }
            }
        }
        return ans;
    }
}
