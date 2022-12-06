https://leetcode.com/problems/find-all-good-strings/discuss/2345027/Java-or-No-KMP-or-DP
class Solution {
    int M = (int)1e9+7;
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int[][] where = new int[evil.length()][26];
        for (int i = 0; i < evil.length(); i++){
            String s = evil.substring(evil.length()-i);
            for (int j = 0; j < 26; j++){
                String ns = ""+(char)(j+'a')+s;
                for (int k = ns.length(); k >= 0; k--){
                    if (evil.endsWith(ns.substring(0, k))){
                        where[i][j]=k;
                        break;
                    }
                }
            }
        }
        int ans = solve(s2, evil, where) - solve(s1, evil, where) + M;
        return ans%M + (s2.contains(evil)? 0 : 1);
    }

    private int solve(String s, String evil, int[][] where){
        int[][][] dp = new int[s.length()+1][evil.length()+1][2];
        dp[s.length()][0][1]=1;
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = 0; j < evil.length(); j++){
                for (int k = 0; k < 26; k++){
                    for (int c = 0; c < 2; c++){
                        int nc = c;
                        if (k < s.charAt(i) - 'a'){
                            nc=0;
                        }else if (k > s.charAt(i) - 'a'){
                            nc=1;
                        }
                        dp[i][where[j][k]][nc]+=dp[i+1][j][c];
                        dp[i][where[j][k]][nc]%=M;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < evil.length(); i++){
            ans += dp[0][i][0];
            ans %= M;
        }
        return ans;
    }
}
