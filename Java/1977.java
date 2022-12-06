class Solution {
    public int numberOfCombinations(String num) {
        if (num.charAt(0) == '0'){
            return 0;
        }
        int M = (int)1e9+7, n = num.length();
        int[][] dp = new int[n][n];
        int[][] pre= new int[n][n];
        int[][] lcp= new int[n][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++){
            pre[0][i]=1;
        }
        for (int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (num.charAt(i) == num.charAt(j)){
                    lcp[i][j] = i==n-1||j==n-1? 1 : lcp[i+1][j+1] + 1;
                }
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = i; j < n && num.charAt(i) > '0'; j++){
                int len = j-i+1;
                dp[i][j] += pre[i-1][i-1] - (i-len<0?0:pre[i-len][i-1]);
                dp[i][j] %= M;
                dp[i][j] += M;
                dp[i][j] %= M;
                if (i-len >= 0 && (len <= lcp[i-len][i] || num.charAt(i+lcp[i-len][i]) >= num.charAt(i-len+lcp[i-len][i]))){
                    dp[i][j] += dp[i-len][i-1];
                    dp[i][j] %= M;
                }
            }
            for (int j = i; j < n; j++){
                pre[i][j]=dp[i][j]+pre[i-1][j];
                pre[i][j] %= M;
            }
        }
        return pre[n-1][n-1];
    }
}

// class Solution {
//     public int numberOfCombinations(String num) {
//         if (num.charAt(0) == '0'){
//             return 0;
//         }
//         int M = (int)1e9+7, n = num.length(), ans = 0;
//         int[][] dp = new int[n][n];
//         Arrays.fill(dp[0], 1);
//         for (int i = 0; i < n; i++){
//             for (int j = i; j < n && num.charAt(i) > '0'; j++){
//                 int len = j-i+1;
//                 for (int k = i-1; k >= 0 && i-k < len; k--){
//                     dp[i][j] += dp[k][i-1];
//                 }
//                 if (i-len >= 0 && num.substring(i, j+1).compareTo(num.substring(i-len, i)) >= 0){
//                     dp[i][j] += dp[i-len][i-1];
//                 }
//             }
//         }
//         for (int i = 0; i < n; i++){
//             ans += dp[i][n-1];
//         }

//         return ans;
//     }
// }
