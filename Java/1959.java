class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length, max = 0, sum = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
            dp[i] = max * (i + 1) - sum;
        }

        for (int i = 1; i <= k; i++){
            int[] next = new int[n];
            for (int j = 1; j < n; j++){
                max = sum = 0;
                next[j] = Integer.MAX_VALUE;
                for (int m = j; m > 0; m--){
                    max = Math.max(max, nums[m]);
                    sum += nums[m];
                    next[j] = Math.min(next[j], max * (j - m + 1) - sum + dp[m - 1]);
                }
            }
            dp = next;
        }

        return dp[n - 1];
    }
}

// class Solution {
//     public int minSpaceWastedKResizing(int[] nums, int k) {
//         int n = nums.length;
//         int[][] dp = new int[k + 1][n];

//         int a = 0, b = 0;
//         for (int i = 0; i < n; i++){
//             a = Math.max(a, nums[i]);
//             b += nums[i];
//             dp[0][i] = a * (i + 1) - b;
//         }

//         for (int i = 1; i <= k; i++){
//             for (int j = 0; j < n; j++){
//                 int max = 0, sum = 0;
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for (int w = j; w > 0; w--){
//                     max = Math.max(max, nums[w]);
//                     sum += nums[w];
//                     if (dp[i - 1][w - 1] != Integer.MAX_VALUE){
//                         dp[i][j] = Math.min(dp[i][j], max * (j - w + 1) - sum + dp[i - 1][w - 1]);
//                     }
//                 }
//             }
//         }

//         return dp[k][n - 1];
//     }
// }
