class Solution {
    public int equalDigitFrequency(String s) {
        int ans = 0, p = 31, m = (int)(1e9+7);

        for (int i = 1; i <= s.length(); i++){
            Set<Long> seen = new HashSet<>();
            int[] count = new int[10];
            long hash = 0, h = 1;
            for (int j = 0; j < i; j++){
                count[s.charAt(j) - '0']++;
                hash = (hash * p + s.charAt(j)) % m;
                if (j < i - 1){
                    h = h * p % m;
                }
            }
            for (int j = i; j <= s.length(); j++){
                if (ok(seen, hash, count)){
                    seen.add(hash);
                    ans++;
                }
                if (j == s.length()) break;
                count[s.charAt(j) - '0']++;
                count[s.charAt(j - i) - '0']--;
                hash = (((hash -  h * s.charAt(j - i)) * p + s.charAt(j)) % m + m) % m;
            }
        }

        return ans;
    }

    private boolean ok(Set<Long> seen, long hash, int[] count){
        if (seen.contains(hash)) return false;
        int i = -1;
        for (int n : count){
            if (n == 0) continue;
            if (i != -1 && n != i) return false;
            if (i == -1) i = n;
        }
        return true;
    }
}
