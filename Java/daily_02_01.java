class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[128];
        int miss = 0, n = s.length(), m = p.length();
        if (m > n) return ans;
        for (char ch : p.toCharArray()) if (++cnt[ch] == 1) ++miss;
        for (int i = 0; i < m; i++) if (--cnt[s.charAt(i)] == 0) --miss;

        for (int i = m; i <= n; i++){
            if (miss == 0) ans.add(i - m);
            if (i == n) break;
            if (--cnt[s.charAt(i)] == 0) --miss;
            if (++cnt[s.charAt(i - m)] == 1) ++miss;
        }

        return ans;
    }
}
