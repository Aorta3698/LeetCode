https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/discuss/1648211/Java-or-DP-or-5-Lines-or-Similar-to-1128.
class Solution {
    public long numberOfSubstrings(String s) {
        long ans = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray())
            ans += count[ch - 'a']++;
        return ans;
    }
}
