https://leetcode.com/problems/valid-palindrome-ii/discuss/1904862/Java-or-2-Pointers
class Solution {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while(lo < hi && s.charAt(lo) == s.charAt(hi)){
            lo++;
            hi--;
        }
        return check(s, lo + 1, hi) || check(s, lo, hi - 1);
    }

    private boolean check(String s, int lo, int hi){
        while(lo < hi && s.charAt(lo) == s.charAt(hi)){
            lo++;
            hi--;
        }
        return lo >= hi;
    }
}
