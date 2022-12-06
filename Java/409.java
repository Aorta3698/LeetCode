class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) count[ch]++;
        for (int n : count) ans += (n / 2) * 2;

        return ans + (1 - ans / s.length());
    }
}
