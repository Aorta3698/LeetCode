class Solution {
    public int distinctSequences(int n) {
        if (n==1)
            return 6;
        int[][][] dp = new int[n][7][7];
        int M = (int)1e9+7;
        int[][] valid = {
            {},
            {1, 2, 3, 4, 5, 6},
            {1, 3, 5},
            {1, 2, 4, 5},
            {1, 3, 5},
            {1, 2, 3, 4, 6},
            {1, 5}
        };
        for (int i = 1; i <= 6; i++){
            for (int j : valid[i]){
                if (j!=i){
                    dp[0][j][i]=1;
                }
            }
        }
        for (int i = 1; i < n-1; i++){
            for (int j = 1; j <= 6; j++){
                for (int k : valid[j]){
                    for (int m : valid[k]){
                        if (k!=m&&j!=k&&j!=m){
                            dp[i][k][j]=(dp[i][k][j]+dp[i-1][m][k])%M;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++){
            for (int j = 1; j <= 6; j++){
                ans += dp[n-2][i][j];
            }
        }
        return (int)(ans % M);
    }
}
