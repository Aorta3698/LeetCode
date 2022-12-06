class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1};
        int MAX = (int)1e6;
        for (int i = 0; i < obstacles.length; i++){
            if (obstacles[i] == 0){
                int p = i > 0? obstacles[i - 1] - 1 : -1;
                if (p >= 0){
                    dp[p] = Math.min(dp[(p + 1) % 3], dp[(p + 2) % 3]) + 1;
                }
                continue;
            }
            int j = obstacles[i] - 1;
            int a = (j + 1) % 3;
            int b = (j + 2) % 3;
            dp[a] = dp[a] == MAX? dp[b] + 1 : dp[a];
            dp[b] = dp[b] == MAX? dp[a] + 1 : dp[b];
            dp[j] = MAX;
        }

        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}
