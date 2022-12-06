https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/discuss/2357248/Java-or-Space-O(2n)-or-Bottom-Up-DP
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[] dp = new int[1<<n];
        int[] w = new int[1<<n];
        Arrays.fill(dp, 100);
        Arrays.fill(w, 1000);
        dp[0]=0;
        for (int i = 1; i < 1<<n; i++){
            for (int j = 0; j < n; j++){
                if ((i & 1 << j) > 0){
                    int extra = 0, wh = w[i^1<<j]+tasks[j];
                    if (wh > sessionTime){
                        extra = 1;
                        wh=tasks[j];
                    }
                    dp[i] = Math.min(dp[i], dp[i^1<<j]+extra);
                    if (dp[i^1<<j]+extra==dp[i]){
                        w[i]=Math.min(wh, w[i]);
                    }
                }
            }
        }
        return dp[(1<<n)-1];
    }
}
