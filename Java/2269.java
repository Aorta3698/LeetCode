class Solution {
    public int divisorSubstrings(int num, int k) {
        int M = (int)Math.pow(10, k);
        int cur = 0, ans = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < k; i++){
            cur = 10 * cur + s.charAt(i) - '0';
        }
        for (int i = k; i <= s.length(); i++){
            if (cur > 0 && num % cur == 0){
                ++ans;
            }
            if (i < s.length()){
                cur = (10 * cur + s.charAt(i) - '0') % M;
            }
        }
        return ans;
    }
}
