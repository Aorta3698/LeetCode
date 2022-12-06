https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/discuss/1635334/Java-or-Constant-Space-or-O(N)-or-DP-or-Comments
class Solution {
    public long getDescentPeriods(int[] prices) {
        long prev = 0, count = prices.length;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i - 1] == -1){
                count += ++prev;
            }else
                prev = 0;
        }

        return count;
    }
}
