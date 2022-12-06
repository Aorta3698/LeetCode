class Solution {
    public int minOperations(String s) {
        int diff = 0, bit = 0;
        for (char ch : s.toCharArray()){
            if (ch - '0' != bit) diff++;
            bit = 1 - bit;
        }

        int min = diff;
        bit = 1; diff = 0;
        for (char ch : s.toCharArray()){
            if (ch - '0' != bit) diff++;
            bit = 1 - bit;
        }

        return Math.min(min, diff);
    }
}
