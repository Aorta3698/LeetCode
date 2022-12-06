class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, ans = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(j) - t.charAt(j));
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}
// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int n = s.length(), lo = 0, hi = n;
//         while (lo < hi){
//             int mid = (lo + hi + 1) >> 1;

//             int cost = 0;
//             for (int i = 0; i < mid; i++){
//                 cost += Math.abs(s.charAt(i) - t.charAt(i));
//             }
//             for (int i = mid; i <= n; i++){
//                 if (cost <= maxCost){
//                     break;
//                 }
//                 if (i < n){
//                     cost += Math.abs(s.charAt(i) - t.charAt(i));
//                     cost -= Math.abs(s.charAt(i - mid) - t.charAt(i - mid));
//                 }
//             }
//             if (cost <= maxCost) lo = mid;
//             else hi = mid - 1;
//         }

//         return lo;
//     }
// }
