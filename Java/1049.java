class Solution {
    public int lastStoneWeightII(int[] stones) {
        // Split it into two groups
        // Result is A - B, and it has to be minimized.
        // A + B = sum, so A and B both have to be as close to sum / 2 as possible.
        // Let's find B, which is 0 <= B <= sum / 2.

        int n = stones.length, sum = 0;
        boolean[] dp = new boolean[1501];
        dp[0] = true;

        for (int i = 0; i < n; i++){
            sum += stones[i]; // the max j can go is prefix sum of current all positive values.
            for (int j = Math.min(sum, 1500); j >= stones[i]; j--){
                dp[j] |= dp[j - stones[i]];
            }
        }

        // for (int i = 0; i < n; i++){
        //     for (int j = 1500; j >= 0; j--){
        //         if (j >= stones[i]){
        //             dp[j] |= dp[j - stones[i]];
        //         }
        //     }
        //     sum += stones[i];
        // }

        for (int i = sum / 2; i >= 0; --i){
            if (dp[i]){
                return (sum - i) - (i);
            }
        }

        return -1;

    }
}

// WORSE SOLUTION BELOW

// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length, ans = 3001;
//         int[][] dp = new int[n + 1][6001];
//         dp[0][3000] = 1;
//         for (int i = 1; i <= n; i++){
//             for (int j = 0; j <= 6000; j++){
//                 if (dp[i - 1][j] > 0){
//                     dp[i][j + stones[i - 1]]++;
//                     dp[i][j - stones[i - 1]]++;
//                 }
//             }
//         }
//         // 6 - (7 - 2) = 6 + (-5)

//         for (int i = 3000; i <= 6000; i++){
//             if (dp[n][i] > 0){
//                 ans = Math.min(ans, i - 3000);
//             }
//         }

//         return ans;
//     }
// }
