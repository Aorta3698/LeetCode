class Solution {
    public int[] amountPainted(int[][] paint) {
        BitSet bit = new BitSet();
        int[] ans = new int[paint.length];
        int i = 0;
        for (int[] p : paint){
            ans[i] = p[1] - p[0] - bit.get(p[0], p[1]).cardinality();
            bit.set(p[0], p[1]);
            i++;
        }
        return ans;
    }
}
