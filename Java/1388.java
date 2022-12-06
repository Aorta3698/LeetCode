class Solution {
    public int maxSizeSlices(int[] slices) {
        return Math.max(solve(slices, false), solve(slices, true));
    }

    private int solve(int[] slices, boolean takeFirst){
        int N = slices.length;
        int T = N/3;
        int st = takeFirst? 0 : 1;
        int[][] dp = new int[N][T+1];
        dp[st][1]=slices[st];
        for (int i = 1+st; i < N; i++){
            for (int j = 1; j <= T; j++){
                dp[i][j]=Math.max(dp[i-1][j], i<2||takeFirst&&i==N-1?0:dp[i-2][j-1]+slices[i]);
            }
        }
        return dp[N-1][T];
    }
}
