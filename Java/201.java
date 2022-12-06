class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i = 31; i >= 0; i--){
            ans <<= 1;
            int lo = left / (1 << i);
            int hi = right/ (1 << i);
            if (lo == hi && lo % 2 == 1) ans++;
        }

        return ans;
    }
    // 0000
    // 0001
    // 0010
    // 0011
    // 0100 - 4
    // 0101
    // 0110
    // 0111 - 7
    // 1000
}
