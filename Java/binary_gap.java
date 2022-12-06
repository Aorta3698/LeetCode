class Solution {
    public int binaryGap(int n) {
        int max = 0, prev = (int)(Math.log(n & (n - 1)) / Math.log(2));
        for (int i = 0; n > 0; i++, n >>= 1)
            if ((n & 1) == 1)
                {max = Math.max(i - prev, max); prev = i;}

        return max;
    }
}
