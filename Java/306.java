https://leetcode.com/problems/additive-number/discuss/1945108/Java-or-2-For-loop-or-100-Speed
class Solution {
    public boolean isAdditiveNumber(String num) {
        long a = 0, b = 0;
        for (int i = 0; i < num.length() - 2 && a >= 0; i++, b = 0){
            a = (10 * a + num.charAt(i) - '0');
            for (int j = i + 1; j < num.length() - 1 && a >= 0 && b >= 0; j++){
                b = (10 * b + num.charAt(j) - '0');
                if (b >= 0 && check(j + 1, num, a, b))
                    return true;
                if (num.charAt(i + 1) == '0')
                    break;
            }
            if (num.charAt(0) == '0')
                break;
        }

        return false;
    }

    private boolean check(int i, String s, long a, long b){
        String sum = String.valueOf(a + b);
        if (s.substring(i).startsWith(sum))
            return check(i + sum.length(), s, b, a + b);
        return i == s.length();
    }
}
