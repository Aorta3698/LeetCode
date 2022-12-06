class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() == 1) return false;

        Set<Character> uni = new HashSet<>();
        int n = s.length(), j = -1, w = -1;
        for (int i = 0; i < n; uni.add(s.charAt(i++))){
            if (s.charAt(i) == goal.charAt(i)) continue;
            if (w != -1 && j != -1) return false;
            if (w == -1 && j != -1) w = i;
            if (j == -1) j = i;
        }

        if (w == -1 && j == -1) return uni.size() != n;
        if (w == -1 || j == -1) return false;
        return s.charAt(w) == goal.charAt(j) && s.charAt(j) == goal.charAt(w);
    }
}
