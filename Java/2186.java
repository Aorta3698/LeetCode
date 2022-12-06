class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        for (char ch : t.toCharArray()) cnt[ch - 'a']--;
        int ans = 0;
        for (int n : cnt) ans += Math.abs(n);
        return ans;
    }
}
