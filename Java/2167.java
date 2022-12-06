class Solution {
    public int minimumTime(String s) {
        int left = 0, right = 0, n = s.length(), ans = n;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        for (int i = 0; i < n; i++){
            prefix[i] = Math.min(left + (s.charAt(i) - '0') * 2, i + 1);
            suffix[n - i - 1] = Math.min(right + (s.charAt(n - i - 1) - '0') * 2, i + 1);
            left = prefix[i];
            right= suffix[n - i - 1];
        }
        for (int i = 0; i < n; i++){
            ans = Math.min(prefix[i] + suffix[i + 1], ans);
        }

        return ans;
    }
}
