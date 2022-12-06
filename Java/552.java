class Solution {
    public int checkRecord(int n) {
        long[][] dp = new long[3][2];
        dp[0][0]=1;
        int m = n, M = (int)1e9+7;
        while(--n>=0){
            long[][] ndp = new long[3][2];
            for (int i = 0; i < 2; i++){
                ndp[2][i] = dp[1][i];
                ndp[1][i] = dp[0][i];
                ndp[0][i] = dp[0][i] + dp[1][i] + dp[2][i];
                ndp[2][i] %= M;
                ndp[1][i] %= M;
                ndp[0][i] %= M;
            }
            ndp[0][1]+=dp[0][0]+dp[1][0]+dp[2][0];
            ndp[0][1]%=M;
            dp = ndp;
        }

        int ans = 0;
        for (long[] d : dp){
            for (long dd : d){
                ans += dd;
                ans %= M;
            }
        }
        return ans;
    }
}
