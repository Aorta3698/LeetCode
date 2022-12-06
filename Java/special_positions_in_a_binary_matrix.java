class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] row = new int[n][2];
        int[] col = new int[m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 1){
                    col[j]++;
                    row[i][0]++;
                    row[i][1] = j;
                }
            }
        }

        int ans = 0;
        for (int[] r : row)
            if (r[0] == 1 && col[r[1]] == 1)
                ans++;

        return ans;
    }
}
