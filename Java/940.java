class Solution {
    public int distinctSubseqII(String s) {
        int M = (int)1e9+7, n = s.length();
        int[] dp = new int[n+1];
        int[] prev = new int[26];
        Arrays.fill(prev, -1);
        dp[0]=1;
        for (int i = 1; i <= n; i++){
            int cur = s.charAt(i-1)-'a';
            dp[i]=2*dp[i-1]-(prev[cur]==-1?0:dp[prev[cur]]);
            dp[i]%=M;
            dp[i]+=M;
            dp[i]%=M;
            prev[cur]=i-1;
        }

        return dp[n]-1;
    }
}
