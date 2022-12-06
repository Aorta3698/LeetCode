class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++, j++){
            while(i < s.length && s[i] < g[j]) i++;
            if (i < s.length) ans++;
        }

        return ans;
    }
}
