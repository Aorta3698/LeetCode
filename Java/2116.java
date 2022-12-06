https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1905993/Keep-a-Range-1-Pass-O(n)-Java
class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1){
            return false;
        }

        int max = 0, min = 0;
        for (int i = 0; i < s.length(); i++){
            max += locked.charAt(i) == '0' || s.charAt(i) == '('? 1 : -1;
            min += locked.charAt(i) == '0' || s.charAt(i) == ')'? -1 : 1;
            if (max < 0){
                return false;
            }
            min = Math.max(0, min);
        }
        return min == 0;
    }
}

class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0){
            return false;
        }
        return check(s, locked, 1) && check(s, locked, -1);
    }

    private boolean check(String s, String t, int d){
        int n = s.length(), free = 0;
        for (int i = d == 1? 0 : n - 1; free >= 0 && i >= 0 && i < n; i += d){
            if (t.charAt(i) == '1'){
                if (s.charAt(i) == '(') free += d;
                if (s.charAt(i) == ')') free -= d;
            }
            if (t.charAt(i) == '0') free++;
        }

        return free >= 0;
    }
}
