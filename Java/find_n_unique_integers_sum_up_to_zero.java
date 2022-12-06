class Solution {
    public int[] sumZero(int n) {
        int[] ans = IntStream.range(0, n).toArray();
        ans[0] = -n * (n - 1) / 2;
        return ans;
    }
}
