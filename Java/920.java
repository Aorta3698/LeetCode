class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        long[] dp = new long[n+1];
        dp[1]=n;
        int M = (int)1e9+7;
        for (int i = 2; i <= goal; i++){
            for (int j = Math.min(i,n); j >= 1; j--){
                dp[j]=dp[j]*Math.max(j-k,0);
                dp[j]+=dp[j-1]*(n-j+1);
                dp[j]%=M;
            }
        }
        return (int)dp[n];
    }
}
