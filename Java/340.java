https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/1660637/Java-Concise-5-Lines-Sliding-Window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        int[] cnt = new int[128];
        for (int i = 0, uniq = 0; i < s.length(); i++){
            if (++cnt[s.charAt(i)] == 1) uniq++;
            if (uniq <= k) ans++;
            else if (--cnt[s.charAt(i - ans)] == 0) uniq--;
        }

        return ans;
    }
}
