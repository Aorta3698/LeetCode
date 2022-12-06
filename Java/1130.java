class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                int[] su = new int[n + 1];
                for (int w = j; w > i; w--) su[w] = Math.max(su[w + 1], arr[w]);
                int l = 0;
                int r = 0;
                dp[i][j] = Integer.MAX_VALUE;

                for (int w = i; w < j; w++){
                    l = Math.max(l, arr[w]);
                    r = su[w + 1];
                    dp[i][j] = Math.min(dp[i][j], dp[i][w] + dp[w + 1][j] + l * r);
                }
            }
        }

        return dp[0][n - 1];
    }
}
