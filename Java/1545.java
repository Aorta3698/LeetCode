https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/discuss/1930234/Java-or-N-is-irrelevant...
class Solution {
    public char findKthBit(int n, int k) {
        boolean flip = false;
        while(k != 1){
            int base = floorTwo(k);
            if (base == k)
                return flip? '0' : '1';
            flip = !flip;
            k = base - (k - base);
        }
        return flip? '1' : '0';
    }

    private int floorTwo(int k){
        while((k & (k - 1)) > 0){
            k &= k - 1;
        }
        return k;
    }
}
