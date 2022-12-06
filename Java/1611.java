class Solution {
    public int minimumOneBitOperations(int n) {
        int[] dp = new int[32];
        dp[0]=1;
        for (int i = 1; i <= 30; i++){
            dp[i]=2*dp[i-1]+1;
        }

        return solve(n, dp);
    }

    private int solve(int n, int[] dp){
        if (n == 0){
            return 0;
        }
        if ((n&(n-1))==0){
            return dp[(int)(Math.log(n)/Math.log(2))];
        }
        for (int i = 30; true; --i){
            if ((n&1<<i)>0){
                n ^= 1 << i;
                n ^= 1 << (i-1);
                return solve(n, dp) + dp[i-1] + 1;
            }
        }
    }
}
