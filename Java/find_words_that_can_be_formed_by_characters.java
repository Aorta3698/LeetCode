class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] allow = new int[26];
        int ans = 0;
        for (char ch : chars.toCharArray()) allow[ch - 'a']++;
        for (String w : words){
            boolean add = true;
            int[] count = new int[26];
            for (char ch : w.toCharArray())
                if (++count[ch - 'a'] > allow[ch - 'a'] && add)
                    add = !add;
            if (add) ans += w.length();
        }

        return ans;
    }
}
