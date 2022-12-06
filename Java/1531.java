class Solution {
    public int getLengthOfOptimalCompression(String s, int K) {
        int n = s.length(), INF = (int)1e9;
        int[][] dp = new int[n+1][K+1];
        int[] len = new int[101];
        len[0]=1;
        for (int i = 1; i <= 100; i++){
            len[i]=len[i/10]+1;
        }
        for (int[] d : dp){
            Arrays.fill(d, INF);
        }
        dp[0][0]=0;
        len[1]=1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= K; j++){
                if (j > 0){
                    dp[i][j] = dp[i-1][j-1];
                }
                int cnt = 0, del = 0;
                for (int k = i; k > 0 && del <= j; k--){
                    if (s.charAt(k-1) == s.charAt(i-1)){
                        cnt++;
                    }else{
                        del++;
                    }
                    if (del <= j){
                        dp[i][j] = Math.min(dp[k-1][j-del] + len[cnt], dp[i][j]);
                    }
                }
            }
        }
        return dp[n][K];
    }
}
