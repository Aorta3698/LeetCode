class Solution {
    private static final int M = (int)1e9 + 7;
    public int numPrimeArrangements(int n) {
        int pCnt = 0;
        for (int i = 2; i <= n; i++)
            if (isPrime(i))
                pCnt++;

        return (int)((fac(pCnt) * fac(n - pCnt)) % M);
    }

    private static boolean isPrime(int n){
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    private static long fac(int n){
        long ans = 1;
        for (int i = 1; i <= n; i++)
            ans = (ans * i) % M;
        return ans;
    }
}
