class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[++n];
        for (int i = 1; i < n; i++){
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
