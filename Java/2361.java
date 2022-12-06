https://leetcode.com/problems/minimum-costs-using-the-train-line/discuss/2371794/This-is-an-OA-question-or-Java-or-DP-or-Explained.
// Time O(n)
// Space O(n)
class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long a = 0, b = expressCost;
        long[] ans = new long[n];
        for (int i = 1; i <= n; i++){
            long aa = 0, bb = 0;
            aa=Math.min(a+regular[i-1], b+express[i-1]);
            bb=Math.min(b+express[i-1], a+regular[i-1]+expressCost);
            a = aa;
            b = bb;
            ans[i-1]=Math.min(a, b);
        }
        return ans;
    }
}
