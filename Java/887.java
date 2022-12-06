class Solution {
    public int superEggDrop(int e, int n) {
        int[][] dp = new int[n+1][e+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= e; j++){
                if (j == 1 || i == 1){
                    dp[i][j] = i;
                    continue;
                }

                int lo = 1, hi = i;
                while(lo < hi){
                    int mid = (lo + hi + 1) >> 1;
                    if (dp[mid - 1][j - 1] <= dp[i - mid][j]){
                        lo = mid;
                    }else{
                        hi = mid - 1;
                    }
                }
                dp[i][j] = Math.max(dp[lo - 1][j - 1], dp[i - lo][j]) + 1;

                // TIME LIMIT EXCEEDED UNFORTUNATELY
                //
                // for (int k = 1; k <= i; k++){
                //     dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                // }
            }
        }

        return dp[n][e];
    }
}

// (dp[0][j - 1], dp[i - 1][j])
// (dp[1][j - 1], dp[i - 2][j])
// (dp[2][j - 1], dp[i - 3][j])
// ...
// (dp[i - 1][j - 1], dp[0][j]);
// (x, y)
// x is increasing, y is decreasing
// x goes from 0 to some positive number
// y goes from some positive number to 0
//
// Hmmmm. Maybe binary search?
