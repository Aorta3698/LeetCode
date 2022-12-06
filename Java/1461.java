class Solution {
    public boolean hasAllCodes(String s, int k) {
        int cur = 0, M = 1 << k;
        for (int i = 0; i < Math.min(k, s.length()); i++){
            cur = cur * 2 + s.charAt(i) - '0';
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = k; i <= s.length(); i++){
            seen.add(cur);
            if (i < s.length()){
                cur = (2 * cur + s.charAt(i) - '0') % M;
            }
        }

        return seen.size() == M;
    }
}
