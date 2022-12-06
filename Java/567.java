class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[128];
        int uniq = 0, n = s1.length(), m = s2.length();
        if (n > m) return false;

        for (char ch : s1.toCharArray()){
            if (++cnt[ch] == 1){
                uniq++;
            }
        }

        for (int i = 0; i < n; i++){
            if (--cnt[s2.charAt(i)] == 0 && --uniq == 0){
                return true;
            }
        }

        for (int i = n; i < m; i++){
            if (--cnt[s2.charAt(i)] == 0) --uniq;
            if (++cnt[s2.charAt(i - n)] == 1) ++uniq;
            if (uniq == 0) return true;
        }

        return false;
    }
}
