class Solution {
    public int change(int amount, int[] coins) {
        //careful not to put the amount in the outer loop, otherwise
        //1 + 2 + 2 is counted in dp[4], dp[3], dp[2], and dp[1]. Duplicates!
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins){
            for (int i = c; i <= amount; i++){
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    // BackTracking works but too slow
    // private void backtrack(int start, int amount, int[] coins){
    //     if (amount == 0){
    //         re++;
    //         return;
    //     }
    //     if (amount < 0) return;

    //     for (int i = start; i < coins.length; i++){
    //         backtrack(i, amount - coins[i], coins);
    //     }
    // }
}
