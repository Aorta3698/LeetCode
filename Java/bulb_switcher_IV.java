class Solution {
    public int minFlips(String target) {
        int count = 0;
        char[] t = target.toCharArray();
        for (int i = t.length - 1; i > 0; i--)
            if (t[i - 1] == '1' && t[i] == '0')
                count+=2;

        return count + t[t.length - 1] - '0';
    }
}
