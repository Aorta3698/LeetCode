class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0]=s.charAt(0)=='0'?0:1;
        for (int i = 1; i < s.length(); i++){
            int val = Integer.parseInt(s.substring(i-1, i+1));
            if (val%10 >= 1 && val%10 <= 9){
                dp[i]+=dp[i-1];
            }
            if (val>=10&&val<=26){
                dp[i]+=i<2?1:dp[i-2];
            }
        }
        return dp[s.length()-1];
    }
}
