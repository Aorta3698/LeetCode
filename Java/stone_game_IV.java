class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        return canWin(dp, n);
    }

    private boolean canWin(boolean[] dp, int n){
        if (n == 0) return false;
        if (dp[n]) return true;

        for (int i = 1; i*i <= n; i++){
            if(!canWin(dp, n - i*i)){
                dp[n] = true;
                return true;
            }
        }

        return false;
    }
}
