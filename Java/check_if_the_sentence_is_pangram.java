class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] az = new int[26];
        for (char ch : sentence.toCharArray())
            az[ch - 'a']++;
        for (int i : az)
            if (i == 0)
                return false;

        return true;
    }
}
