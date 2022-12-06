class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int hi = n, lo = 1;
        for (int i = 0; i < k; i++){
            ans[i] = i % 2 == 0? hi-- : lo++;
        }
        for (int i = k, rest = i % 2 == 0? lo : hi; i < n; i++){
            ans[i] = rest;
            rest += k % 2 == 0? 1 : -1;
        }
        return ans;
    }
}
