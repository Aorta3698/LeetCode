class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;

        int[] move = new int[26];

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != t.charAt(i)){
                int cnt = (t.charAt(i) - s.charAt(i) + 26) % 26;
                if (cnt + move[cnt]++ * 26 > k){
                    return false;
                }
            }
        }

        return true;
    }
}
