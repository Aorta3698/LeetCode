class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length, k = days[0].length, INF = (int)-1e9;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for (int i = 0; i < k; i++){
            int[] ndp = new int[n];
            Arrays.fill(ndp, INF);
            for (int j = 0; j < n; j++){
                for (int d = 0; d < n && dp[j] != INF; d++){
                    if (d == j || flights[j][d] == 1){
                        ndp[d]=Math.max(ndp[d], dp[j]+days[d][i]);
                    }
                }
            }
            dp=ndp;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
