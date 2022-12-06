class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbCopy = new StringBuilder();
        for (String word : word1)
            sb.append(word);
        for (String word: word2)
            sbCopy.append(word);

        return sb.toString().equals(sbCopy.toString());
    }
}
