class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i){
            char ch = s.charAt(i);
            if (ch == '#'){
                sb.append((char)('a' + Integer.parseInt(s.substring(i - 2, i)) - 1));
                i-=2;
                continue;
            }
            sb.append((char)('a' + ch - '1'));
        }

        return sb.reverse().toString();
    }
}
