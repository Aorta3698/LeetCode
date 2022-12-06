class Solution {
    public long numberOfWays(String s) {
        int suf = 0, pre = 0;
        for (char ch : s.toCharArray()){
            suf += ch - '0';
        }

        long ans = 0;
        for (int i = 0; i < s.length() - 1; i++){
            suf -= s.charAt(i) - '0';
            if (s.charAt(i) == '0'){
                ans += 1L * suf * pre;
            }else{
                ans += 1L * (i - pre) * (s.length() - 1 - i - suf);
            }
            pre += s.charAt(i) - '0';
        }

        return ans;
    }
}
