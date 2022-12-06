class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;
        int n = 0;
        for (int c : count){
            if (c == 0) continue;
            if (n == 0) {n = c; continue;}
            if (n != c) return false;
        }

        return true;
    }
}
