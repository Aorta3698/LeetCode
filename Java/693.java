class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = -1, prev = -2;
        while(n > 0 && cur != prev){
            prev = cur;
            cur = n & 1;
            n >>= 1;
        }

        return cur != prev;
    }
}
