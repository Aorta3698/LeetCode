class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++){
            int lo = -1, hi = i;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (events[mid][1] < events[i - 1][0]){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }
            int pick = events[i - 1][2] + dp[lo + 1][0];
            int skip = dp[i - 1][1];
            dp[i][1] = Math.max(pick, skip);
            dp[i][0] = Math.max(events[i - 1][2], dp[i - 1][0]);
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}
