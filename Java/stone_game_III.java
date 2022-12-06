class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[][] dp = new int[stoneValue.length][2];
        getMax(stoneValue, 0, 0, dp);
        return dp[0][0] == 0? "Tie" : dp[0][0] > 0? "Alice" : "Bob";
    }

    private int getMax(int[] stones, int idx, int count, int[][] dp){
        if (idx == stones.length) return 0;
        if (dp[idx][count] != 0) return dp[idx][count];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < Math.min(stones.length, idx + 3); i++){
            sum += stones[i];
            if (count % 2 == 0)
                max = Math.max(sum + getMax(stones, i + 1, Math.abs(count - 1), dp), max);
            else
                min = Math.min(-sum + getMax(stones, i + 1, Math.abs(count - 1), dp), min);
        }

        return dp[idx][count] = count % 2 == 0? max : min;
    }

    // public String stoneGameIII(int[] stoneValue) {
    //     int[][] dp = new int[stoneValue.length][50000];
    //     getMax(stoneValue, 0, 0, dp);
    //     return dp[0][0] == 0? "Tie" : dp[0][0] > 0? "Alice" : "Bob";
    // }

    // private int getMax(int[] stones, int idx, int count, int[][] dp){
    //     if (idx == stones.length) return 0;
    //     if (dp[idx][count] != 0) return dp[idx][count];

    //     int sum = 0;
    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;
    //     for (int i = idx; i < Math.min(stones.length, idx + 3); i++){
    //         sum += stones[i];
    //         if (count % 2 == 0)
    //             max = Math.max(sum + getMax(stones, i + 1, count + 1, dp), max);
    //         else
    //             min = Math.min(- sum + getMax(stones, i + 1, count + 1, dp), min);
    //     }

    //     return dp[idx][count] = count % 2 == 0? max : min;
    // }
}
