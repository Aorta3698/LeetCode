/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix mat) {
        int n = mat.dimensions().get(1), m = mat.dimensions().get(0);
        int lo = 0, hi = n;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            int i;
            for (i = 0; i < m; i++){
                if (mat.get(i, mid) == 1){
                    break;
                }
            }
            if (i < m) hi = mid;
            else lo = mid + 1;
        }

        return lo == n? -1 : lo;
    }
}
