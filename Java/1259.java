class Solution {
    public int numberOfWays(int numPeople) {
        int M = (int)1e9+7;
        long[] dp = new long[numPeople+1];
        dp[0]=1;
        for (int i = 2; i <= numPeople; i+=2){
            for (int j = 0; j < i;j+=2){
                dp[i]+=dp[j]*dp[i-j-2];
                dp[i]%=M;
            }
        }
        return (int)dp[numPeople];
    }
}
