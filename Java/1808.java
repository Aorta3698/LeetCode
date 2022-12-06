class Solution {
    public int maxNiceDivisors(int primeFactors) {
        // x+y+z + ....  <= p
        // find the max xyz...
        // 6 -> 3+3 -> 3*3 = 9
        // 3 - > 3 -> 3
        // greedily take 3, followed by 2, unless we have 4, then we take 2*2
        int M = (int)1e9+7, two = (3-primeFactors%3)%3, e = (primeFactors-2*two)/3;
        long cur = 3, ans = 1;
        while(e > 0){
            if ((e&1)==1){
                ans *= cur;
                ans %= M;
            }
            cur *= cur;
            cur %= M;
            e >>= 1;
        }
        two = two==0? 1 : 2*two;
        return primeFactors==1?1:(int)(ans*two%M);
    }
}
