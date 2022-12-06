class Solution {
    public int minOperationsMaxProfit(int[] customers, int G, int L) {
        int ans = -1, max = 0, profit = 0;
        for (int i = 0, cur = 0; i < customers.length || cur > 0; i++){
            if (i < customers.length){
                cur += customers[i];
            }
            int on = Math.min(4, cur);
            profit += on * G - L;
            cur -= on;
            if (profit > max){
                ans = i + 1;
                profit = max;
            }
        }

        return ans;
    }
}
