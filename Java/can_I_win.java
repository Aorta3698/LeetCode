class Solution {
    int[] dp = new int[1 << 21];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        if (desiredTotal == 0) return true;
        if (n * (n + 1) / 2 < desiredTotal) return false;

        return canWin(new boolean[n + 1], n, desiredTotal, 0);
    }

    private boolean canWin(boolean[] used, int max, int total, int key){
        if (total <= 0) return false;
        // int key = hash(used, total);
        if (dp[key] != 0) return dp[key] == 1;

        for (int i = 1; i <= max; i++){
            if (used[i]) continue;

            used[i] = true;
            if (!canWin(used, max, total - i, key|(1 << i))) {
                dp[key] = 1;
                used[i] = false;
                return true;
            }
            used[i] = false;
        }

        dp[key] = -1;
        return false;
    }

    // private int hash(boolean[] used, int total){
    //     int key = 0;
    //     for (int i = 1; i < used.length; i++)
    //         if (used[i])
    //             key |= 1 << i;

    //     return key;
    // }
}
