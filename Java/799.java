class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[100];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++){
            for (int j = i; j >= 0; j--){
                dp[j] = (Math.max(0, dp[j] - 1) + (j > 0? Math.max(0, dp[j - 1] - 1) : 0)) / 2;
            }
        }
        return dp[query_glass] >= 1? 1 : dp[query_glass];
    }
}
