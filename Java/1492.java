class Solution {
    public int kthFactor(int n, int k) {
        List<int[]> factors = new ArrayList<>();
        for (int i = 2; i * i <= n; i++){
            while(n % i == 0){
                if (factors.isEmpty() || factors.get(factors.size() - 1)[0] != i){
                    factors.add(new int[]{i, 0});
                }
                factors.get(factors.size() - 1)[1]++;
                n /= i;
            }
        }
        if (n > 1){
            factors.add(new int[]{n, 1});
        }

        List<Integer> all = new ArrayList<>();
        solve(0, 1, all, factors);
        Collections.sort(all);
        return all.size() < k? -1 : all.get(k - 1);
    }

    private void solve(int i, int cur, List<Integer> all, List<int[]> factors){
        if (i == factors.size()){
            all.add(cur);
            return;
        }
        int[] lvl = factors.get(i);
        int pre = 1;
        for (int j = 0; j <= lvl[1]; j++){
            solve(i + 1, cur * pre, all, factors);
            pre *= lvl[0];
        }
    }
}
