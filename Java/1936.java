class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0, prev = 0;
        for (int i = 0; i < rungs.length; i++){
            ans += (rungs[i] - prev - 1) / dist;
            prev = rungs[i];
        }
        return ans;
    }
}
