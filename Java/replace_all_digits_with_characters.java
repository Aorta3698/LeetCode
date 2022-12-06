class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0) sb.append(s.charAt(i));
            else sb.append(shift(s.charAt(i - 1), s.charAt(i) - '0'));
        }

        return sb.toString();
    }

    private char shift(char ch, int sh){
        return (char)(ch + sh);
    }
}
