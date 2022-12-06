class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(o -> o.length()));
        int uni = 0;
        int count[] = new int[26];
        for (char ch : licensePlate.toCharArray())
            if (Character.isAlphabetic(ch) && ++count[Character.toLowerCase(ch) - 'a'] == 1)
                ++uni;

        for (String w : words){
            int c = 0;
            int[] tmp = new int[26];
            for (char ch : w.toCharArray())
                if (++tmp[ch - 'a'] == count[ch - 'a'])
                    ++c;
            if (c == uni) return w;
        }

        return null;
    }
}
