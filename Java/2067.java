class Solution {
    public int equalCountSubstrings(String s, int count) {
        int uniq = 0;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++){
            if (!seen[s.charAt(i) - 'a']){
                seen[s.charAt(i) - 'a'] = true;
                ++uniq;
            }
        }

        int ans = 0;
        for (int i = 1; i <= uniq; i++){
            ans += find(s, count, i);
        }

        return ans;
    }

    private int find(String s, int hi, int k){
        int[] count = new int[26];
        int ok = 0, ans = 0;

        for (int i = 0, j = 0; i < s.length(); i++){
            if (++count[s.charAt(i) - 'a'] == hi){
                ++ok;
            }
            if (i - j + 1 > hi * k && count[s.charAt(j++) - 'a']-- == hi){
                --ok;
            }
            if (ok == k){
                ans++;
            }
        }

        return ans;
    }
}
