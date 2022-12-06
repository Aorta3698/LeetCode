class Solution {
    public int maxProfit(int[] prices) {
        int min = 10000000, ans = 0;
        for (int p : prices){
            min = Math.min(p, min);
            ans = Math.max(ans, p-min);
        }
        return ans;
    }
}
