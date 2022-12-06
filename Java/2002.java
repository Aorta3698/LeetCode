class Solution {
    public int maxProduct(String s) {
        int n = s.length(), ans = 0;
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++){
            find(s, dp, i);
        }

        for (int i = 1; i < 1 << n; i++){
            int mask = i ^ ((1 << n) - 1);
            // int mask = ~i & ((1 << n) - 1);
            for (int j = mask; j > 0 && dp[i] > 0; j = (j - 1) & mask){
                ans = Math.max(ans, dp[i] * dp[j]);
            }
        }

        return ans;
    }

    private void find(String s, int[] dp, int vis){
        int lo = 0, hi = s.length() - 1, count = 0;
        while(lo <= hi){
            while (((1 << lo) & vis) == 0){
                lo++;
            }
            while (((1 << hi) & vis) == 0){
                hi--;
            }
            if (lo > hi){
                break;
            }
            if (s.charAt(lo) != s.charAt(hi)){
                return;
            }
            count += (lo == hi? 1 : 2);
            lo++;
            hi--;
        }

        dp[vis] = count;
    }
}

// ANOTHER SOLUTION (SLOWER)
// class Solution {
//     public int maxProduct(String s) {
//         int n = s.length(), ans = 0;
//         boolean[] ok = new boolean[1 << n];
//         find(0, s, ok, 0, new StringBuilder());

//         for (int i = 1; i < (1 << n); i++){
//             int mask = ~i & ((1 << n) - 1);
//             for (int j = mask; j > 0 && ok[i]; j = (j - 1) & mask){
//                 if (ok[j]){
//                     ans = Math.max(ans, Integer.bitCount(i) * Integer.bitCount(j));
//                 }
//             }
//         }

//         return ans;
//     }

//     private void find(int idx, String s, boolean[] ok, int cur, StringBuilder sb){
//         if (idx == s.length()){
//             return;
//         }

//         if (isP(sb.toString())){
//             ok[cur] = true;
//         }
//         find(idx + 1, s, ok, cur, sb);

//         sb.append(s.charAt(idx));
//         cur |= (1 << idx);
//         if (isP(sb.toString())){
//             ok[cur] = true;
//         }

//         find(idx + 1, s, ok, cur, sb);
//         sb.setLength(sb.length() - 1);
//     }

//     private boolean isP(String s){
//         int i = 0, j = s.length() - 1;
//         while(i < j){
//             if (s.charAt(i) != s.charAt(j)){
//                 break;
//             }
//             i++;
//             j--;
//         }

//         return i >= j;
//     }
// }
