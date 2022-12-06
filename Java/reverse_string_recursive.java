
class Solution {
    public void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }

    private void helper (int start, int end, char[] s){
        if (start >= end) return;
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
        helper(++start, --end, s);
    }
}
