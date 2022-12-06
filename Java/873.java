class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        int ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[i] - arr[j]; j--){
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k == -1) continue;
                dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
                ans = Math.max(dp[i][j], ans);
            }
        }

        return ans == 0? 0 : ans + 2;
    }
}
