class Solution {
    public int climbStairs(int n) {
        //dp[i] = dp[i - 1] + dp[i - 2]
        //dp[0] = 1, dp[1] = 2

        if (n == 1) return 1;
        int pp = 1;
        int p = 2;

        while (n-- > 2){
            int cur = pp + p;
            pp = p;
            p = cur;
        }

        return p;
    }
}
