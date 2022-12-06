class Solution {
    public int createSortedArray(int[] instructions) {
        int M = (int)1e9+7, ans = 0;
        int[] bit = new int[100002];
        for (int i : instructions){
            int L = sum(bit, i-1);
            int R = sum(bit, 100000) - sum(bit, i);
            ans += Math.min(L, R);
            ans %= M;
            update(bit, i, 1);
        }
        return ans;
    }

    private void update(int[] bit, int idx, int inc){
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx] += inc;
        }
    }

    private int sum(int[] bit, int idx){
        int ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}
