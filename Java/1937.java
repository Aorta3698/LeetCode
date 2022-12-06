
class Solution {
    public long maxPoints(int[][] points) {
        int n = points[0].length, m = points.length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++){
            long[] next = new long[n];
            long lmax = 0, rmax = 0;
            for (int j = 0; j < n; j++){
                int k = n - 1 - j;
                lmax = Math.max(--lmax, dp[j] + points[i][j]);
                rmax = Math.max(--rmax, dp[k] + points[i][k]);
                next[j] = Math.max(lmax, next[j]);
                next[k] = Math.max(rmax, next[k]);
            }
            dp = next;
        }

        return Arrays.stream(dp).max().getAsLong();
    }
}
