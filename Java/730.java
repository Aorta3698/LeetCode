https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/2324157/Similar-to-940.-Distinct-Subsequences-II-or-Java-or-O(n2)
class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length(), ans = 0, M = (int)1e9+7, E = 4;
        int[][] next = new int[n][E];
        int[][] prev = new int[n][E];
        int[][][] dp = new int[n][n][E];
        for (int i = 0; i < E; i++){
            for (int j = 0, k = n - 1; j < n; j++, k--){
                prev[j][i] = s.charAt(j) - 'a' == i? j : (j == 0?   -1 : prev[j-1][i]);
                next[k][i] = s.charAt(k) - 'a' == i? k : (k == n-1? -1 : next[k+1][i]);
            }
        }
        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (s.charAt(i) != s.charAt(j)){
                    continue;
                }
                int cur = s.charAt(i) - 'a';
                dp[i][j][cur] += i == j? 1:2;
                for (int k = 0; k < E && j-i >= 2; k++){
                    if (next[i+1][k] != -1 && prev[j-1][k] != -1){
                        dp[i][j][cur] += dp[next[i+1][k]][prev[j-1][k]][k];
                        dp[i][j][cur] %= M;
                    }
                }
            }
        }
        for (int k = 0; k < E; k++){
            if (next[0][k] != -1 && prev[n-1][k] != -1){
                ans += dp[next[0][k]][prev[n-1][k]][k];
                ans %= M;
            }
        }
        return ans;
    }
}
