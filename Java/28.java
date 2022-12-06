class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m > n) return -1;
        int M = (int)1e9 + 9, p = 31;
        long h = 1, a = 0, b = 0;
        for (int i = 0; i < m - 1; i++)
            h = (h * p) % M;

        for (int i = 0; i < m; i++){
            a = a * p + haystack.charAt(i);
            b = b * p + needle.charAt(i);
            a %= M;
            b %= M;
        }

        for (int i = m; i <= n; i++){
            if (a == b && needle.equals(haystack.substring(i - m, i)))
                return i - m;
            if (i < n) 
                a = (p * (a - h * haystack.charAt(i - m)) + haystack.charAt(i)) % M;
            if (a < 0) a += M;
        }

        return m == 0? 0 : -1;
    }
}
