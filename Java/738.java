https://leetcode.com/problems/monotone-increasing-digits/discuss/1952518/Concise-BruteForce-Java
class Solution {
    public int monotoneIncreasingDigits(int n) {
        return (int)solve(1, 0, n);
    }

    private int solve(int st, long cur, int max){
        if (cur > max)
            return 0;
        long ans = cur;
        for (int i = st; i <= 9; i++){
            ans = Math.max(solve(i, 10 * cur + i, max), ans);
        }
        return (int)ans;
    }
}

// class Solution {
//     public int monotoneIncreasingDigits(int n) {
//         return solve(1, 0, n);
//     }
//
//     private int solve(int st, int cur, int max){
//         if (cur > max)
//             return 0;
//         int ans = cur;
//         for (int i = st; i <= 9; i++){
//             if ((Integer.MAX_VALUE - i) / 10 < cur)
//                 break;
//             ans = Math.max(solve(i, 10 * cur + i, max), ans);
//         }
//         return ans;
//     }
// }
