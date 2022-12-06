class Solution {
    public int[] countBits(int n) {
        //f(2n + 1) -> f(2n) + 1
        //f(2n) -> f(n)
        int[] ans = new int[n + 1];
        for (int i = 1; i < ans.length; i++)
            ans[i] = i % 2 == 1? ans[i - 1] + 1 : ans[i / 2];

        return ans;
    }
}
