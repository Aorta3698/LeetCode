class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smap = new int[128];
        int[] tmap = new int[128];
        Arrays.fill(tmap, -1);
        Arrays.fill(smap, -1);
        for (int i = 0; i < s.length(); i++){
            int a = s.charAt(i), b = t.charAt(i);
            if (smap[a] != -1 && smap[a] != b ||
                tmap[b] != -1 && tmap[b] != a)
                return false;
            smap[a] = b;
            tmap[b] = a;
        }
        return true;
    }
}
