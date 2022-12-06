/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = (int)1e4;
        int lo = 0;
        while(lo <= hi){
            int mid = (hi + lo) / 2;
            if (reader.get(mid) > target) hi = mid - 1;
            if (reader.get(mid) < target) lo = mid + 1;
            if (reader.get(mid) == target) return mid;
        }

        return -1;
    }
}
