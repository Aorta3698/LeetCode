https://leetcode.com/problems/numbers-at-most-n-given-digit-set/discuss/1633497/Java-or-10-Lines-or-Log(N)-or-Comments
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = (int)Math.log10(n), ans = 0;
        for (int i = 1; i <= len; i++) ans += (int)Math.pow(digits.length, i);
        while(n >= Integer.parseInt(digits[0]) && len == (int)Math.log10(n)){
            int f = n / (int)Math.pow(10, len);
            for (int i = 0; i < digits.length; i++){
                int cur = Integer.parseInt(digits[i]);
                if (cur < f || cur == f && len == 0) ans += (int)Math.pow(digits.length, len);
                if (cur == f){ n %= (int)Math.pow(10, len--); break;}
                if (cur > f || i == digits.length - 1) return ans;
            }
        }

        return ans;
    }
}
