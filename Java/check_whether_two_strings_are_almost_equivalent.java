class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[][] count = new int[26][2];
        for (char ch : word1.toCharArray()) count[ch - 'a'][0]++;
        for (char ch : word2.toCharArray()) count[ch - 'a'][1]++;
        for (int[] c : count)
            if (Math.abs(c[0] - c[1]) > 3)
                return false;

        return true;
    }
}
