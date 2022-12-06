https://leetcode.com/problems/divide-two-integers/discuss/2085377/Java-or-No-long-multi-divide-mod-or-Bitwise-Short-solution
class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend < 0) ^ (divisor < 0);
        int ans = 0, mul = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while(divisor >= (Integer.MIN_VALUE >> 1) && divisor >= dividend){
            divisor <<= 1;
            mul++;
        }
        while(mul >= 0){
            if (divisor >= dividend){
                ans -= (1 << mul);
                dividend -= divisor;
            }
            divisor >>= 1;
            mul--;
        }
        return neg? ans :
            ans == Integer.MIN_VALUE?
            Integer.MAX_VALUE : -ans;
    }
}
