class Solution {
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        int M = (int)1e9+7;
        for (int i = 1; i <= s.length(); i++){
            for (int j = i,cur=0; j-1>=0&&i-j<=10; j--){
                long val = Long.parseLong(s.substring(j-1, i));
                if (val>k){
                    break;
                }
                if (s.charAt(j-1)!='0'){
                    dp[i]+=dp[j-1];
                    dp[i]%=M;
                }
            }
        }
        return dp[s.length()];
    }
}
