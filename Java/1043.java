class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length, max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < k; i++){
            max = Math.max(arr[i], max);
            dp[i] = max * (i + 1);
        }
        for (int i = k; i < n; i++){
            max = 0;
            for (int j = 0; j < k; j++){
                max = Math.max(arr[i - j], max);
                dp[i] = Math.max((j + 1) * max + dp[i - j - 1], dp[i]);
            }
        }

        return dp[n - 1];
    }
}
