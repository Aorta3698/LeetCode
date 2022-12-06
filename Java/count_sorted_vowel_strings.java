class Solution {
    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;

        for (int j = 1; j < n; j++){
            e = a + e;
            i = e + i;
            o = i + o;
            u = o + u;
        }

        return a + e + i + o + u;
    }
}
