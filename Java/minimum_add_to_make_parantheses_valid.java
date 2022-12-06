class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int count = 0;
        for (char ch : s.toCharArray()){
            if (ch == '(' && count < 0) {ans -= count; count = 0;}
            if (ch == '(') count++;
            if (ch == ')') count--;
        }

        return ans + Math.abs(count);
    }
}
