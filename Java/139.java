https://leetcode.com/problems/word-break/discuss/2260931/Java-or-DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = i; j >= 1&&!dp[i]; --j){
                dp[i]|=set.contains(s.substring(j-1,i))&&dp[j-1];
            }
        }

        return dp[s.length()];
    }
}
