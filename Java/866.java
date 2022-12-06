class Solution {
    public int primePalindrome(int n) {
        if (isPrime(n) && isPalindrome(n))
            return n;
        while(true){
            n = nextPalindrome(n);
            if (isPrime(n))
                return n;
        }
    }

    private boolean isPrime(int n){
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0)
                return false;
        }
        return n != 1;
    }

    private int nextPalindrome(int n){
        int sz = countLength(n);
        boolean isOdd = sz % 2 == 1;
        int[] d = new int[2];
        int mod = (int)Math.pow(10, sz / 2);
        d[0] = isOdd? 10 * mod : mod;
        d[1] = isOdd? d[0] / 10 : 0;
        int tail = n % mod;
        int mid = isOdd? (n / mod) % 10 : 0;
        int head = n / d[0];

        if (reverse(head) <= tail){
            if (isOdd && ++mid == 10){ //13925, 19925, 99925
                ++head;
                mid = 0;
            }
            if (!isOdd){
                ++head;
            }
        }

        return head * d[0] + mid * d[1] + reverse(head);
    }

    private boolean isPalindrome(int n){
        return reverse(n) == n;
    }

    private int reverse(int n){
        int ans = 0;
        while(n > 0){
            ans = 10 * ans + n % 10;
            n /= 10;
        }
        return ans;
    }

    private int countLength(int n){
        if (n < 10)         return 1;
        if (n < 100)        return 2;
        if (n < 1000)       return 3;
        if (n < 10000)      return 4;
        if (n < 100000)     return 5;
        if (n < 1000000)    return 6;
        if (n < 10000000)   return 7;
        if (n < 100000000)  return 8;
        if (n < 1000000000) return 9;
        return 10;
    }
}
