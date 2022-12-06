class Solution {
    private final int M = (int)1e9 + 7;
    public int numTilings(int n) {
        //dp[n] = dp[n-1] * 2 + dp[n-3]
        if (n <= 2) return n;

        int minusTwo = 1;
        int minusOne = 2;
        int cur = 5;
        for (int i = 3; i < n; i++){
            long next = (long)cur * 2 + (long)minusTwo;
            next %= M;
            minusTwo = minusOne;
            minusOne = cur;
            cur = (int)next;
        }

        return cur;
    }
}
