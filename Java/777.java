https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/1934746/Java-Check-Both-Directions-or-96-Speed
class Solution {
    public boolean canTransform(String start, String end) {
        return check(start, end, 'R') && check(start, end, 'L');
    }

    private boolean check(String s, String e, char t){
        int n = s.length();
        int start = t == 'L'? 0 : n - 1;
        int d = t == 'L'? 1 : -1;
        int count = 0;
        for (int i = start, j = i; j >= 0 && j < n; j += d, i = (j - i) / d > 0? j : i){
            if (e.charAt(j) == t){
                while(i >= 0 && i < n && s.charAt(i) == 'X'){
                    i += d;
                }
                if (i == -1 || i == n || s.charAt(i) != t){
                    return false;
                }
                count++;
                i += d;
            }
            if (s.charAt(j) == t && --count < 0)
                return false;
        }
        return true;
    }
}
