class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long n = 0, p = power % modulo, M = modulo, h = 1;
        int m = s.length(), ans = -1;
        for (int i = 1; i < k; i++){
            h *= p;
            h %= M;
        }

        for (int i = m - 1; i >= m - k; i--){
            n = n * p + get(s.charAt(i));
            n %= M;
        }

        for (int i = m - k - 1; i >= -1; i--){
            if (n == hashValue) ans = i + 1;
            if (i >= 0) n = ((n - h * get(s.charAt(i + k))) % M * p + get(s.charAt(i)) + M) % M;
            if (n < 0) n += M;
        }

        return s.substring(ans, ans + k);
    }

    private int get(char ch){
        return ch - 'a' + 1;
    }
}
