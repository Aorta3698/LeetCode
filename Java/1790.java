class Solution {
    public boolean areAlmostEqual(String o, String t) {
        int j = -1, w = -1;
        for (int i = 0; i < o.length(); i++){
            if (o.charAt(i) == t.charAt(i)) continue;
            if (j != -1 && w != -1) return false;
            if (j != -1) w = i;
            if (j == -1) j = i;
        }

        return j == -1 && w == -1 ||
            j >= 0 && w >= 0 && o.charAt(j) == t.charAt(w) && o.charAt(w) == t.charAt(j);
    }
}
