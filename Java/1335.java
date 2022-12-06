class Solution {
    public int minDifficulty(int[] A, int d) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i]=i==0?A[0]:Math.max(A[i], dp[i-1]);
        }
        for (int i = 1; i < d; i++){
            for (int j = n-1; j >= 0; j--){
                int max = 0;
                dp[j]=Integer.MAX_VALUE;
                for (int k = j; k >= i; k--){
                    max = Math.max(max, A[k]);
                    dp[j]=Math.min(dp[j], max+dp[k-1]);
                }
            }
        }
        return dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1];
    }
}
