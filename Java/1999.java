class Solution {
    public int findInteger(int k, int digit1, int digit2) {
        return solve(0, k, digit1, digit2);
    }

    private int solve(long cur, int k, int a, int b){
        if (cur >= Integer.MAX_VALUE)
            return -1;
        if (cur > k && cur % k == 0){
            return (int)cur;
        }
        long na = 10 * cur + a, nb = 10 * cur + b;
        na = na > 0? solve(na, k, a, b) : -1;
        nb = nb > 0? solve(nb, k, a, b) : -1;
        if (nb > 0 && na > 0)
            return (int)Math.min(na, nb);
        return na == -1? (int)nb : (int)na;
    }
}
