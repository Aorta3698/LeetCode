class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return solve(n, (1<<n)-1, 0, n-1, firstPlayer-1, secondPlayer-1, new HashMap<>());
    }

    private int[] solve(int n, int mask, int lo, int hi, int a, int b, Map<Integer, int[]> map){
        while((mask&1<<hi)==0){
            hi--;
        }
        while((mask&1<<lo)==0){
            lo++;
        }
        if (lo>=hi){
            if (map.containsKey(mask)){
                return map.get(mask);
            }
            int[] res = solve(n, mask, 0, n-1, a, b, map);
            res[0]++; res[1]++;
            map.put(mask, res);
            return res;
        }
        if (lo==a&&hi==b||lo==b&&hi==a){
            return new int[]{1, 1};
        }
        int[] ans = new int[]{100, 0};
        if (hi!=a&&hi!=b){
            int[] x = solve(n, mask^1<<hi, lo+1, hi-1, a, b, map);
            ans[0] = Math.min(ans[0], x[0]);
            ans[1] = Math.max(ans[1], x[1]);
        }
        if (lo!=a&&lo!=b){
            int[] y = solve(n, mask^1<<lo, lo+1, hi-1, a, b, map);
            ans[0] = Math.min(ans[0], y[0]);
            ans[1] = Math.max(ans[1], y[1]);
        }
        return ans;
    }
}
