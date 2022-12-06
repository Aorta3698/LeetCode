class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++){
            int one = 0, zero = 0;
            for (int j = 0; j < strs[i].length(); j++){
                one += strs[i].charAt(j) - '0';
            }
            zero = strs[i].length() - one;
            for (int j = m; j >= 0; j--){
                for (int k = n; k >= 0; k--){
                    if (zero <= j && one <= k){
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
