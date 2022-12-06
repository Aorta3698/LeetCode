https://leetcode.com/problems/valid-palindrome-iv/discuss/2248146/Java-or-4-lines
class Solution {
    public boolean makePalindrome(String s) {
        int i = 0, j = s.length()-1, miss=0;
        while(i<j&&(s.charAt(i)==s.charAt(j)||++miss<3)){
            i++;
            j--;
        }
        return miss < 3;
    }
}
