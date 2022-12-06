https://leetcode.com/problems/k-empty-slots/discuss/2229441/Java-or-BitSet-or-Just-a-few-lines
class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        BitSet bit = new BitSet();
        int i = 0;
        for (int n : bulbs){
            ++i;
            bit.set(n);
            int p = bit.previousSetBit(n-1);
            int m = bit.nextSetBit(n+1);
            if (p != -1 && n-p-1==k || m != -1 && m-n-1==k){
                return i;
            }
        }
        return -1;
    }
}
