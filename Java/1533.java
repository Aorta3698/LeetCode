/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */
https://leetcode.com/problems/find-the-index-of-the-large-integer/discuss/1881181/Java-or-Binary-Search-1-If-else-statement

class Solution {
    public int getIndex(ArrayReader reader) {
        int lo = 0, hi = reader.length() - 1;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            int ret = reader.compareSub(lo, mid, mid + (hi - lo) % 2, hi);
            if (ret >= 0){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}
