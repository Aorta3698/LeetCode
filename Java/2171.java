class Solution {
    public long minimumRemoval(int[] beans) {
        long ans = Long.MAX_VALUE, n = beans.length, prefix = 0, sum = 0;
        Arrays.sort(beans);
        for (int b : beans) sum += b;
        for (int i = 0; i < n; i++){
            long keep = prefix + sum - (long)beans[i] * (n - i);
            prefix += beans[i];
            sum -= beans[i];
            ans = Math.min(ans, keep);
        }

        return beans.length == 1? 0 : ans;
    }
}
