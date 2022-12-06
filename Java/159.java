class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0, n = s.length();
        int[] cnt = new int[128];
        for (int i = 0, uni = 0; i < n; i++){
            if (++cnt[s.charAt(i)] == 1) uni++;
            if (uni <= 2) ans++;
            else if (--cnt[s.charAt(i - ans)] == 0) uni--;
        }

        return ans;
    }
}
