class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int sum = 0;
        int pow = 1;
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i)=='1' && sum <= k){
                sum += pow;
            }
            if (s.charAt(i)=='0'||sum<=k){
                ans++;
            }
            if (pow <= k){
                pow <<= 1;
            }
        }
        return ans;
    }
}
