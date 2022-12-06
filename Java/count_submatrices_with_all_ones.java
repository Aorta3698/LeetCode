https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/1622664/Java-or-O(NMM)-or-One-Triple-For-Loop
class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        int[][][] dp = new int[n + 1][m + 1][3];
        //0 = up-down 1 width, 1 = left-right 1 width, 2 = 2 by 2 or more

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 1){
                    ans--;
                    dp[i + 1][j + 1][0] = dp[i][j + 1][0] + 1;
                    dp[i + 1][j + 1][1] = dp[i + 1][j][1] + 1;

                    if (i > 0 && j > 0 && mat[i - 1][j] == 1 && mat[i][j - 1] == 1 && mat[i - 1][j - 1] == 1){
                        int min = Math.min(dp[i + 1][j + 1][1], dp[i][j + 1][1]) - 1;
                        for (int next = 1; next < i && min > 0; next++){
                            dp[i + 1][j + 1][2] += min;
                            min = Math.min(dp[i - next][j + 1][1] - 1, min);
                        }
                        if (min > 0) dp[i + 1][j + 1][2] += min;
                    }

                    for (int cur : dp[i + 1][j + 1]) ans += cur;
                }
            }
        }

        return ans;
    }
}
