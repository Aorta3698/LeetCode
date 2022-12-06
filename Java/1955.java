class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int M = (int)1e9+7;
        long[] dp = new long[3];
        for (int n : nums){
            switch(n){
                case 2 -> dp[2]=(2*dp[2]+dp[1])%M;
                case 1 -> dp[1]=(2*dp[1]+(1<<dp[0])-1)%M;
                case 0 -> dp[0]++;
            };
        }
        return (int)dp[2];
    }
}
