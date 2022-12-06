class Solution {
    public int minScoreTriangulation(int[] values) {
        // There is no need to mod over like the below shows.
        //
        // when d == 2, we computed [0,2],[1,3],[2,4],[3,5],
        // but there are actually 2 more valid triangles : [4,0], [5,1], when are they handled?
        //
        // Ans: They are never used in any of the subproblems and were
        //      eventually calculated in [0, 5].
        int ans = 0, n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++){
            for (int j = 0; j + i < n; j++){
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j + 1; k < j + i; k++){
                    int a = values[j] * values[j + i] * values[k];
                    dp[j][j + i] = Math.min(dp[j][j + i], a + dp[j][k] + dp[k][j + i]);
                }
            }
        }

        return dp[0][n - 1];
    }
}

// class Solution {
//     public int minScoreTriangulation(int[] values) {
//         int ans = 0, n = values.length;
//         int[][] dp = new int[n][n];
//         for (int i = 2; i < n; i++){
//             for (int j = 0; j < n; j++){
//                 int e = (j + i) % n;
//                 dp[j][e] = Integer.MAX_VALUE;
//                 for (int k = j + 1; k < j + i; k++){
//                     int a = values[j] * values[e] * values[k % n];
//                     dp[j][e] = Math.min(dp[j][e], a + dp[j][k % n] + dp[k % n][e]);
//                 }
//             }
//         }

//         return dp[0][n - 1];
//     }
// }
