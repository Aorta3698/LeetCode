class Solution {
    int M = (int)1e9+7;
    public int idealArrays(int n, int maxValue) {
        List<Integer>[] factors = new ArrayList[maxValue+1];
        Arrays.setAll(factors, o -> new ArrayList<>());
        for (int i = maxValue; i >= 1; i--){
            for (int j = 1; j*j <= i; j++){
                if (i%j==0){
                    factors[i].add(j);
                    if (j*j!=i){
                        factors[i].add(i/j);
                    }
                }
            }
        }
        int ans = 0;
        Map<Integer, Integer>[] map = new HashMap[maxValue+1];
        Arrays.setAll(map, o -> new HashMap<>());
        for (int i = maxValue; i >= 1; i--){
            ans += solve(i, n-1, factors, map);
            ans %= M;
        }
        return ans;
    }

    private int solve(int cur, int depth, List<Integer>[] factors, Map<Integer, Integer>[] map){
        if (depth == 0){
            return 1;
        }
        if (map[cur].containsKey(depth)){
            return map[cur].get(depth);
        }
        int ans = 0;
        for (int f : factors[cur]){
            if (f<cur||f==1){

            ans += solve(f, depth-1, factors, map);
            ans %= M;
            }
        }
        map[cur].put(depth, ans);
        return ans;
    }
}
