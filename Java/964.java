class Solution {
    public int leastOpsExpressTarget(int x, int t) {
        return solve(x, t, new HashMap<>());
    }

    private int solve(int x, long t, Map<Long, Integer> memo){
        if (memo.containsKey(t)){
            return memo.get(t);
        }
        if (x >= t){
            return (int)Math.min(2*t-1, 2*(x-t));
        }
        int cnt = 0;
        long cur = x;
        while(1L*cur*x < t){
            cur *= x;
            cnt++;
        }

        int ans = (int)Math.min(1L*cur*x-t<t?cnt+2+solve(x, 1L*cur*x - t, memo):(long)1e7, cnt+1+solve(x, t - cur, memo));
        memo.put(t, ans);
        return ans;
    }
}
