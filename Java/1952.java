class Solution {
    public boolean isThree(int n) {
        int sq = (int)Math.sqrt(n);
        return n > 2 && sq * sq == n && isPrime(sq);
    }

    private static boolean isPrime(int n){
        for (int i = 2; i <= (int)Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
