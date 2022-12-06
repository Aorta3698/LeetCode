https://leetcode.com/problems/domino-and-tromino-tiling/discuss/1620736/Java-or-2-Patterns-to-Track-or-With-Picture

class Solution {
    private final int M = (int)1e9+7;
    public int numTilings(int n) {
        //dp[n] = dp[n - 1] + dp[n - 2] + 2 * dp[n - 3] + odd[k - 1];
        //odd[k - 1] = 2 * dp[n - 4] + odd[k - 2]
        if (n < 3) return n;

        long[] dp = new long[]{0, 1, 2, 5};
        long odd = 2;
        while(n-- > 3){
            long next = dp[1] * 2 + dp[2] + dp[3] + 2 * dp[0] + odd;
            odd = (2 * dp[0] + odd) % M;
            dp[0] = dp[1] % M;
            dp[1] = dp[2] % M;
            dp[2] = dp[3] % M;
            dp[3] = next  % M;
        }

        return (int)dp[3];
    }
}
