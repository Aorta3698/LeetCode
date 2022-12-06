class Solution {
    public int rearrangeSticks(int n, int k) {
        int M = (int)1e9+7;
        long[] dp = new long[k+1];
        for (int i = 1; i <= n; i++){
            for (int j = Math.min(i, k); j > 0; j--){
                if (j==i){
                    dp[j]=1;
                }else{
                    dp[j]+=dp[j-1]+dp[j]*(n-i)%M;
                    dp[j]%=M;
                }
            }
        }
        return (int)dp[k];
    }
}
