class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean last = false;
        for (int i = s.length() - 1, cnt = 0; i >= 0; --i){
            if (s.charAt(i) == '-') continue;
            last = false;
            if (Character.isDigit(s.charAt(i))) sb.append(s.charAt(i));
            else sb.append(Character.toUpperCase(s.charAt(i)));
            if (++cnt == k && i != 0 && !last) {cnt = 0; sb.append('-'); last = true;}
        }

        if (last) sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }
}
