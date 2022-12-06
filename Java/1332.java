class Solution {
    public int removePalindromeSub(String s) {
        return new StringBuilder(s).reverse().toString().equals(s)? 1 : 2;
    }
}

class Solution {
    public int removePalindromeSub(String s) {
        int lo = 0, hi = s.length() - 1;
        while(lo < hi)
            if (s.charAt(lo++) != s.charAt(hi--))
                return 2;
        return 1;
    }
}
