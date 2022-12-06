// Advance trade count when buy
//
// Notice that we can actually flip the outer loop and inner loop,
// the ordering does not matter for this question
// But we wouldn't be able to write it in a memory effecient way if flipped
class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[3];
        int[] sell= new int[3];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int p : prices){
            for (int i = 1; i <= 2; i++){
                buy[i] = Math.max(buy[i], sell[i-1]-p);
                sell[i] = Math.max(sell[i], buy[i]+p);
            }
        }
        return sell[2];
    }
}

// Advance trade count when sell

// class Solution {
//     public int maxProfit(int[] prices) {
//         int[] buy = new int[3];
//         int[] sell= new int[3];
//         Arrays.fill(buy, Integer.MIN_VALUE);
//         for (int p : prices){
//             for (int i = 0; i <= 2; i++){
//                 buy[i] = Math.max(buy[i], sell[i]-p);
//                 if (i>0){
//                     sell[i] = Math.max(sell[i], buy[i-1]+p);
//                 }
//             }
//         }
//         return sell[2];
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
//         int[][] buy = new int[3][prices.length];
//         int[][] sell = new int[3][prices.length];
//         // for (int i = 0; i < prices.length; i++){
//         //     buy[0][i] = -prices[i];
//         // }
//         for (int i = 0; i < 2; i++){
//             buy[i][0] = -prices[0];
//         }
//         for (int i = 0; i <= 2; i++){
//             for (int j = 1; j < prices.length; j++){
//                 buy[i][j] = Math.max(sell[i][j-1] - prices[j], buy[i][j-1]);
//                 if (i>0)
//                 sell[i][j] = Math.max(buy[i-1][j-1] + prices[j], sell[i][j-1]);
//             }
//         }
//         return sell[2][prices.length - 1];
//     }
// }
