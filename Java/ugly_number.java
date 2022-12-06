class Solution {
    public boolean isUgly(int n) {
        if (n < 1) return false;

        int p = 2;
        while(true){
            while (n % p == 0) n /= p;
            p++;
            if (n == 1) return true;
            if (p > 5) return false;
        }
    }
}
