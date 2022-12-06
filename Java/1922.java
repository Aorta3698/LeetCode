class Solution {
    int m = (int)(1e9 + 7);
    public int countGoodNumbers(long n) {
        long even = fastPow(5, (n + 1)/2);
        long odd = fastPow(4, n/2);
        return (int)(even * odd % m);
    }

    private long fastPow(int n, long e){
        if (e == 0)
            return 1;
        if (e == 1)
            return n;
        long half = fastPow(n, e / 2) % m;
        long ans = e % 2 == 1? n % m : 1;
        ans = ans * half % m;
        ans = ans * half % m;
        return ans;
    }
}

// import java.math.BigInteger;
//
// class Solution {
//     public int countGoodNumbers(long n) {
//         BigInteger ans = BigInteger.ONE;
//         BigInteger mod = BigInteger.valueOf((int)(1e9 + 7));
//         BigInteger even = BigInteger.valueOf(5);
//         BigInteger odd = BigInteger.valueOf(4);
//         ans = ans.multiply(even.modPow(BigInteger.valueOf((n + 1)/2), mod));
//         ans = ans.multiply(odd.modPow(BigInteger.valueOf(n / 2), mod));
//
//         return ans.mod(mod).intValue();
//     }
// }
