class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int M = (int)1e9+7;
        int N = locations.length;
        int[][] dp = new int[fuel+1][N];
        dp[0][start]=1;
        for (int i = 1; i <= fuel; i++){
            for (int j = 0; j < N;j++){
                for (int k = 0; k < N; k++){
                    int cost = Math.abs(locations[k]-locations[j]);
                    if (i>=cost&&j!=k){
                        dp[i][j]+=dp[i-cost][k];
                        dp[i][j]%=M;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= fuel; i++){
            ans += dp[i][finish];
            ans %= M;
        }
        return ans;
    }
}
