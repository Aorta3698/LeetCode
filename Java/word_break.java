class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //f(n) will be true if f(n-1) is true and s.charAt(last) is in dict.
        //f(n) will be true if f(n-2) is true and s.substring(last 2) is in dict
        //so on and so forth.
        boolean[] dp = new boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < dp.length; i++){
            dp[i] = set.contains(s.substring(0, i+1));
            if (dp[i]) continue;

            for (int j = i; j >= 0; j--){
                dp[i] = dp[i-j] && set.contains(s.substring(i-j+1, i+1));
                if (dp[i]) break;
            }
        }

        return dp[s.length() - 1];
    }
}
