class Solution {
    public int secondHighest(String s) {
        int[] count = new int[10];
        for (char ch : s.toCharArray())
            if (Character.isDigit(ch))
                count[ch - '0']++;

        for (int i = 9, cnt = 2; i >= 0; i--)
            if (count[i] > 0 && --cnt == 0)
                return i;

        return -1;
    }
}
