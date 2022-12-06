class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int ans = 0, prev = bottom - 1;
        Arrays.sort(special);
        for (int n : special){
            ans = Math.max(n - prev - 1, ans);
            prev = n;
        }
        ans = Math.max(ans, top - prev);
        return ans;
    }
}
