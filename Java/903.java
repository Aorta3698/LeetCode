class Solution {
    public int numPermsDISequence(String s) {
        int M = (int)1e9+7;
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++){
            int[] ndp = new int[dp.length];
            for (int j = 0, sum = 0; s.charAt(i) == 'I' && j < s.length()-i; j++){
                sum+=dp[j];
                sum %= M;
                ndp[j]=sum;
            }
            for (int j = s.length()-i, sum = 0; s.charAt(i) == 'D' && j >= 0; j--){
                ndp[j]=sum;
                sum += dp[j];
                sum %= M;
            }
            dp=ndp;
        }

        return dp[0];
    }
}
