class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for (String w : words)
            for (char ch : w.toCharArray())
                count[ch - 'a']++;
        for (int c : count)
            if (c % words.length != 0)
                return false;
        return true;
    }
}
