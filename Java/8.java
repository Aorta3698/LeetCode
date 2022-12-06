https://leetcode.com/problems/string-to-integer-atoi/discuss/1732691/Java-18-lines
class Solution {
    public int myAtoi(String s) {
        int sum = 0;
        int count = 0, m = 0, p = 0;
        for (char ch : s.toCharArray()){
            if (!Character.isDigit(ch)){
                if (count > 0) break;
                else if (ch == '-' && p == 0 && ++m == 1) continue;
                else if (ch == '+' && m == 0 && ++p == 1) continue;
                else if (ch == ' ' && p + m + count == 0) continue;
                else break;
            }

            int prev = sum, d = ch - '0';
            count++;
            sum *= 10;
            sum -= d;
            if ((sum + d) / 10 != prev || sum > prev)
                return m == 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (m == 0 && sum == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return m == 0? -sum : sum;
    }
}
