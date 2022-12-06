class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int dup = 0;
        char prev = s.charAt(0);
        for (char ch : s.toCharArray()){
            dup = prev == ch? ++dup : 1;
            prev = ch;
            if (dup >= 3) continue;
            sb.append(ch);
        }

        return sb.toString();
    }
}
