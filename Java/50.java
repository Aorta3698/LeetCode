class Solution {
    public double myPow(double x, int k) {
        long n = k;
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        for (; n > 0; n >>= 1, x *= x){
            if ((n&1)>0){
                ans *= x;
            }
        }
        return ans;
    }
}
