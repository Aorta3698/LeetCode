class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        int[] suf = new int[s.length()];
        for (int i = s.length() - 1, sum = 0; i >= 0; i--){
            sum = (sum + shifts[i]) % 26;
            suf[i] = sum;
        }
        for (int i = 0; i < s.length(); i++){
            sb.append((char)(((s.charAt(i) - 'a' + suf[i]) % 26) + 'a'));
        }
        return sb.toString();
    }
}
