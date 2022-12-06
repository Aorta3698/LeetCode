class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[] cMax = new int[m];
        int[][] rMin = new int[n][2];

        for (int i = 0; i < n; i++){
            rMin[i][0] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++){
                if (matrix[i][j] < rMin[i][0]){
                    rMin[i][0] = matrix[i][j];
                    rMin[i][1] = j;
                }
                cMax[j] = Math.max(matrix[i][j], cMax[j]);
            }
        }

        for (int[] row : rMin)
            if (row[0] == cMax[row[1]])
                ans.add(row[0]);

        return ans;
    }
}
