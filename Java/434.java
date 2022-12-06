class Solution {
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;

        int cnt = s.charAt(0) == ' '? 0 : 1;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')
                cnt++;

        return cnt;
    }
}
