class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] pre = new long[candiesCount.length];
        for (int i = 0; i < candiesCount.length; i++){
            pre[i] = candiesCount[i] + (i > 0? pre[i - 1] : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++){
            int type = queries[i][0];
            int day = queries[i][1]+1;
            int cap = queries[i][2];
            long max = 1L*day * cap, min = day;
            ans[i] = min <= pre[type]
                  && max >= (type == 0? 0 : pre[type-1])+1;
        }
        return ans;
    }
}

// Binary Search O(nlogn) Solution
//
// class Solution {
//     public boolean[] canEat(int[] candiesCount, int[][] queries) {
//         long[] pre = new long[candiesCount.length];
//         for (int i = 0; i < candiesCount.length; i++){
//             pre[i] = candiesCount[i] + (i > 0? pre[i - 1] : 0);
//         }
//         boolean[] ans = new boolean[queries.length];
//         for (int i = 0; i < queries.length; i++){
//             int type = queries[i][0];
//             int day = queries[i][1]+1;
//             int cap = queries[i][2];
//             ans[i] = findType(day, pre) <= type
//                   && findType(1L*day * cap, pre) >= type;
//         }
//         return ans;
//     }

//     private int findType(long eaten, long[] pre){
//         int lo = 0, hi = pre.length;
//         while(lo < hi){
//             int mid = (lo + hi) >> 1;
//             if (pre[mid] >= eaten)
//                 hi = mid;
//             else
//                 lo = mid + 1;
//         }
//         return lo;
//     }
// }
