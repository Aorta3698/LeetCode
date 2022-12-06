class Solution {
    public int maximumWhiteTiles(int[][] T, int carpetLen) {
        int ans = 0, n = T.length, count = 0;
        Arrays.sort(T, Comparator.comparingInt(o -> o[0]));
        for (int i = 0, j = 0; i < n && j < n;){
            if (T[j][0] + carpetLen > T[i][1]){
                count += T[i][1] - T[i][0] + 1;
                ans = Math.max(ans, count);
                i++;
            }else{
                int partial = Math.max(0, carpetLen - (T[i][0] - T[j][0]));
                ans = Math.max(ans, count + partial);
                count -= (T[j][1] - T[j][0] + 1);
                j++;
            }
        }
        return ans;
    }
}
// class Solution {
//     public int maximumWhiteTiles(int[][] T, int carpetLen) {
//         int ans = 0, n = T.length;
//         Arrays.sort(T, Comparator.comparingInt(o -> o[0]));
//         int[] gaps = new int[n];
//         int[] count = new int[n];
//         for (int i = 0; i < n; i++){
//             gaps[i] = i == 0? 0 : gaps[i - 1] + T[i][0] - T[i-1][1]-1;
//             count[i] = T[i][1] - T[i][0] + 1 + (i == 0? 0 : count[i-1]);
//         }
//         for (int i = 0; i < n; i++){
//             int lo = i, hi = n-1, del = i == 0? 0 : count[i - 1];
//             while(lo < hi){
//                 int mid = (lo + hi + 1) >> 1;
//                 if (gaps[mid] + count[mid] - gaps[i] - del <= carpetLen){
//                     lo = mid;
//                 }else{
//                     hi = mid - 1;
//                 }
//             }
//             if (lo == n-1){
//                 ans = Math.max(ans, count[lo] - del);
//                 break;
//             }
//             int cur = gaps[lo] + count[lo] - gaps[i] - del;
//             int partial = Math.max(0, carpetLen - (cur + T[lo+1][0]-T[lo][1]-1));
//             ans = Math.max(ans, count[lo] - del + partial);
//         }
//         return Math.min(ans, carpetLen);
//     }
// }
