class Solution {
    public int longestRepeatingSubstring(String s) {
        int lo = 0, hi = s.length() - 1, m = (int)1e9 + 7, p = 31;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;

            Set<Long> seen = new HashSet<>();
            long hash = 0, h = 1;
            int i;
            for (i = 0; i < mid; i++){
                if (i < mid - 1){
                    h = (h * p) % m;
                }
                hash = (hash * p + s.charAt(i)) % m;
            }

            for (i = mid; i <= s.length(); i++){
                if (!seen.add(hash)){
                    break;
                }
                if (i < s.length()){
                    hash = ((hash - h * s.charAt(i - mid)) * p % m + s.charAt(i) + m) % m;
                }
            }

            if (i <= s.length()) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }
}
