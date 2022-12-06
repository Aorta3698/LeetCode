https://leetcode.com/problems/count-number-of-texts/discuss/2078802/DP-O(N)-O(1)-Grouping-Java-Solution
class Solution {
    public int countTexts(String A) {
        int M = (int)(1e9 + 7);
        int[] ways = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int[] dp = new int[5];
        long ans = 1;
        for (int i = 0; i < A.length(); i++){
            int k = i % 5;
            dp[k] = 0;
            for (int j = 1; j <= ways[A.charAt(i) - '0']; j++){
                if (i - j < 0 || A.charAt(i) != A.charAt(i - j)){
                    dp[k]++;
                    break;
                }
                dp[k] = (dp[k] + dp[(k - j + 5) % 5]) % M;
            }
            if (i == A.length() - 1 || A.charAt(i) != A.charAt(i + 1)){
                ans = (ans * dp[k]) % M;
            }
        }
        return (int)ans;
    }
}

// class Solution {
//     public int countTexts(String A) {
//         int M = (int)(1e9 + 7);
//         int[] ways = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
//         int[] dp = new int[A.length()];
//         long ans = 1;
//         for (int i = 0; i < A.length(); i++){
//             for (int j = 1; j <= ways[A.charAt(i) - '0']; j++){
//                 if (i - j < 0 || A.charAt(i) != A.charAt(i - j)){
//                     dp[i]++;
//                     break;
//                 }
//                 dp[i] = (dp[i] + dp[i - j]) % M;
//             }
//             if (i == A.length() - 1 || A.charAt(i) != A.charAt(i + 1)){
//                 ans = (ans * dp[i]) % M;
//             }
//         }
//         return (int)ans;
//     }
// }
