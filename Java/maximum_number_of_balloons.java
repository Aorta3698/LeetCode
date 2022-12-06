class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char ch : text.toCharArray())
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                count[ch - 'a']++;

        int ans = Integer.MAX_VALUE, c = 0;
        for (int i = 0; i < 26; i++){
            int n = count[i];
            if (n == 0) continue;
            if (i == 'l' - 'a') ans = Math.min(n / 2, ans);
            else if (i == 'o' - 'a') ans = Math.min(n / 2, ans);
            else ans = Math.min(n, ans);
            c++;
        }

        return ans == Integer.MAX_VALUE || c < 5? 0 : ans;
    }
}
