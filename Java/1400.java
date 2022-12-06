class Solution {
    public boolean canConstruct(String s, int k) {
        int upper = s.length(), lower = 0;
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        for (int c : cnt) if (c % 2 == 1) lower++;
        return upper >= k && k >= lower;
    }
}
