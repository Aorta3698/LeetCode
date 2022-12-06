class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[] dp = new boolean[s2.length()+1];
        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s2.length(); j++){
               dp[j]=i+j==0||j>0&&dp[j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)||i>0&&dp[j]&&s1.charAt(i-1)==s3.charAt(i+j-1);
            }
        }

        return dp[s2.length()];
    }
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()){
            return false;
        }

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                boolean one = i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[j];
                boolean two = j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[j - 1];
                if (j > 0){
                    dp[j] = two;
                }
                if (i > 0){
                    dp[j] = j > 0? dp[j] || one : one;
                }

                // if (j == 0 && i == 0){
                //     dp[j] = true;
                // }else if (j == 0){
                //     dp[j] = one;
                // }else if (i == 0){
                //     dp[j] = two;
                // }else{
                //     dp[j] = one || two;
                // }
            }
        }

        return dp[m];
    }
}

// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int n = s1.length(), m = s2.length();
//         if (n + m != s3.length()){
//             return false;
//         }

//         boolean[] dp = new boolean[m + 1];

//         for (int i = 0; i <= n; i++){
//             boolean[] next = new boolean[m + 1];
//             if (i == 0) {
//                 next[0] = true;
//             }
//             for (int j = 0; j <= m; j++){
//                 if (j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1) && next[j - 1]){
//                     next[j] = true;
//                 }
//                 if (i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[j]){
//                     next[j] = true;
//                 }
//             }
//             dp = next;
//         }

//         return dp[m];
//     }
// }

// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int n = s1.length(), m = s2.length();
//         if (n + m != s3.length()){
//             return false;
//         }

//         int[][] memo = new int[n + 1][m + 1];
//         solve(s1, s2, s3, 0, 0, memo);

//         return memo[n][m] == 1;
//     }

//     private int solve(String a, String b, String c, int i, int j, int[][] memo){
//         if (memo[i][j] != 0){
//             return memo[i][j];
//         }
//         if (i == a.length() && j == b.length()){
//             return memo[i][j] = 1;
//         }

//         int n = a.length(), m = b.length();
//         if (i < n && a.charAt(i) == c.charAt(i + j) && solve(a, b, c, i + 1, j, memo) == 1 ||
//             j < m && b.charAt(j) == c.charAt(i + j) && solve(a, b, c, i, j + 1, memo) == 1){
//             return memo[i][j] = 1;
//         }

//         return memo[i][j] = -1;
//     }
// }
