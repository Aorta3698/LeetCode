class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int start = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (start == -1 && ch == '(') start = i;
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count == 0) {sb.append(s.substring(start + 1, i)); start = -1;}
        }

        return sb.toString();
    }
}
