class Solution {
    public int countSubstrings(String s, String t) {
        //let dp[i][j][0] be the number of identical substrings that ends at i, j
        //let dp[i][j][1] be the number of substrings that differ by 1 char that ends at i, j
        //we want to sum up all dp[i][j][1] that we came across.
        int[][][] dp = new int[s.length() + 1][t.length() + 1][2];

        int ans = 0;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                boolean same = s.charAt(i - 1) == t.charAt(j - 1);
                dp[i][j][0] = same? dp[i - 1][j - 1][0] + 1 : 0;
                dp[i][j][1] = same? dp[i - 1][j - 1][1] : dp[i - 1][j - 1][0] + 1;
                ans += dp[i][j][1];
            }
        }

        return ans;
    }
}
