https://leetcode.com/problems/valid-palindrome-ii/discuss/1636529/Java-or-DFS-or-5-Lines-or-Should-be-Medium
class Solution {
    public boolean validPalindrome(String s) {
        return check(s.toCharArray(), 0, s.length() - 1, 0);
    }

    private boolean check(char[] arr, int lo, int hi, int count){
        while(lo < hi){
            if (arr[lo] == arr[hi]) {lo++; hi--; continue;}
            if (++count == 2) return false;
            if (check(arr, lo + 1, hi, count) || check(arr, lo, hi - 1, count)) return true;
        }

        return true;
    }
}
