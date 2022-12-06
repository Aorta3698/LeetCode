class Solution {
    public boolean canConvert(String o, String t) {
        if (o.length() != t.length()) return false;
        if (o.equals(t)) return true;

        int n = o.length();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        boolean[] seen = new boolean[26];
        int uni = 0;
        for (int i = 0; i < n; i++){
            int x = o.charAt(i) - 'a', y = t.charAt(i) - 'a';
            if (map[x] != -1 && map[x] != y) return false;
            if (map[x] == -1) {map[x] = y; seen[y] = true;}
        }

        int cnt = 0;
        for (boolean b : seen)
            if (b) cnt++;
        return cnt < 26;
    }
}
