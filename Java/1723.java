https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/discuss/2266554/Java-or-Bottom-up-DP-with-comments
class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int N = 1 << jobs.length, INF = (int)2e9;
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[N-1]=0;
        for (int i = 0; i < k; i++){
            int[] next = new int[N];
            Arrays.fill(next, INF);
            for (int j = 0; j < N; j++){
                for (int m = j; m > 0 && dp[j]!=INF; m = (m-1)&j){
                    if (Integer.bitCount(j)-Integer.bitCount(m)<k-i-1){
                        continue;
                    }
                    int sum = 0;
                    for (int s = 0; s < jobs.length; s++){
                        if ((m&1<<s)>0){
                            sum += jobs[s];
                        }
                    }
                    int res = Math.max(sum, dp[j]);
                    next[j^m]=Math.min(res, next[j^m]);
                }
            }
            dp=next;
        }
        return dp[0];
    }
}

class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        return solve((1<<jobs.length)-1, k, jobs, new int[k+1][1<<jobs.length]);
    }

    private int solve(int mask, int k, int[] jobs, int[][] memo){
        if (k==0 && mask == 0){
            return 0;
        }
        if (mask == 0 || k == 0){
            return Integer.MAX_VALUE;
        }
        if (memo[k][mask]>0){
            return memo[k][mask];
        }

        int ans = Integer.MAX_VALUE;
        int got = Integer.bitCount(mask);
        for (int i = mask; i > 0; i=(i-1)&mask){
            if (got-Integer.bitCount(i)<k-1){
                continue;
            }
            int sum = 0;
            for (int j = 0; j < jobs.length; j++){
                if ((i & (1<<j))>0){
                    sum+=jobs[j];
                }
            }
            int res = Math.max(sum, solve(mask^i, k-1, jobs, memo));
            ans = Math.min(ans, res);
        }
        return memo[k][mask]=ans;
    }
}
