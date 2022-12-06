class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while(true){
            if (i >= j || s.charAt(i) != s.charAt(j))
                return Math.max(0, j - i + 1);
            i = find(s, i, 1, s.charAt(i));
            j = find(s, j, -1,s.charAt(j));
        }
    }

    private int find(String s, int i, int d, char ch){
        while(i >= 0 && i < s.length() && s.charAt(i) == ch){
            i += d;
        }
        return i;
    }
}
