class Solution {
    public int houseOfCards(int n) {
        //2, 5, 8, 11, 14
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i += 3){
            for (int j = n; j >= i; j--){
                dp[j] += dp[j - i];
            }
        }
        return dp[n];
    }
}
