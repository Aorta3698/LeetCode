class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int m = rides.length;
        long[] dp = new long[m + 1];
        Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));

        for (int i = 1; i <= m; i++){
            int lo = -1, hi = i - 1;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (rides[mid][1] <= rides[i - 1][0]){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }

            dp[i] = Math.max(rides[i - 1][1] - rides[i - 1][0] + rides[i - 1][2] + dp[lo + 1], dp[i - 1]);
        }

        return dp[m];
    }
}
