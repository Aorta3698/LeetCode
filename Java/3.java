https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/2085203/Java-or-Sliding-Window-Fixed-Width
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int invalid = 0, i, j;
        int[] count = new int[128];
        for (i = 0, j = 0; i < s.length(); i++){
            if (++count[s.charAt(i)] == 2) {
                ++invalid;
            }
            if (invalid > 0 && --count[s.charAt(j++)] == 1){
                invalid--;
            }
        }
        return i - j;
    }
}
