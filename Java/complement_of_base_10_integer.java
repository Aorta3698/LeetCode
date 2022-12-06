class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int copy = n;
        for(int i = 0; copy > 0; i++, copy >>= 1){
            n ^= (1 << i);
        }

        return n;
    }
}
