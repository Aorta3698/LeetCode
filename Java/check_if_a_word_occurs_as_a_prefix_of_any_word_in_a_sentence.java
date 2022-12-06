class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int idx = 0;
        for (String s : sentence.split(" "))
            if (++idx > 0 && s.startsWith(searchWord))
                return idx;
        return -1;
    }
}
