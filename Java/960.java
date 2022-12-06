class Solution {
    public int minDeletionSize(String[] strs) {
        int[] dp = new int[strs[0].length()+1];
        for (int i = 0; i <= strs[0].length(); i++){
            dp[i]=i;
            for (int j = 0; j < i; j++){
                boolean ok = true;
                for (int k = 0; k < strs.length && ok && i < strs[0].length(); k++){
                    ok &= strs[k].charAt(i)>=strs[k].charAt(j);
                }
                if (ok){
                    dp[i]=Math.min(dp[i],dp[j]+i-j-1);
                }
            }
        }
        return dp[strs[0].length()];
    }
}

// MY OWN
class Solution {
    public int minDeletionSize(String[] strs) {
        int[] dp = new int[strs[0].length()];
        int INF = 1000;
        Arrays.fill(dp, INF);
        dp[0]=0;
        for (int i = 1; i < strs[0].length(); i++){
            int[] ndp = new int[strs[0].length()];
            Arrays.fill(ndp, INF);
            ndp[i]=i;
            for (int j = i-1; j >= 0; j--){
                boolean ok = true;
                for (int k = 0; k < strs.length && ok; k++){
                    ok &= strs[k].charAt(i)>=strs[k].charAt(j);
                }
                if (ok){
                    ndp[i]=Math.min(ndp[i], dp[j]);
                }
                ndp[j]=Math.min(dp[j]+1, ndp[j]);
            }
            dp=ndp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
