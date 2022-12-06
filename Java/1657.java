class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] one = getCount(word1);
        int[] two = getCount(word2);

        for (int i = 0; i < 26; i++){
            if ((one[i] > 0) ^ (two[i] > 0)){
                return false;
            }
        }

        Arrays.sort(one);
        Arrays.sort(two);
        return Arrays.equals(one, two);
    }

    private int[] getCount(String s){
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        return count;
    }
}
