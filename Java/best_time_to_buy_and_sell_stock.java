class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int ans = 0;

        for (int p : prices){
            minSoFar = Math.min(p, minSoFar);
            ans = Math.max(p - minSoFar, ans);
        }

        return ans;
    }
}
