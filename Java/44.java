https://leetcode.com/problems/wildcard-matching/discuss/2338825/Java-or-DP-or-Similar-to-10.-Reg-Expression-Matching
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for (int i = 0; i <= p.length(); i++){
            dp[0][i] = i == 0 || p.charAt(i-1) == '*' && dp[0][i-1];
        }
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
                dp[i][j]=switch(p.charAt(j-1)){
                    case '*': yield dp[i][j-1] || dp[i-1][j];
                    case '?': yield dp[i-1][j-1];
                    default : yield dp[i-1][j-1] && p.charAt(j-1) == s.charAt(i-1);
                };
            }
        }
        return dp[s.length()][p.length()];
    }
}
