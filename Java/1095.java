/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray A) {
        int lo = 1, hi = A.length()-2;
        while(lo < hi){
            int mid = (lo+hi)>>1;
            int m = A.get(mid);
            int r = A.get(mid+1);
            if (r > m){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        int top = lo;
        lo = 0;
        hi = top;
        while(lo <= hi){
            int mid = (lo+hi)>>1;
            int m = A.get(mid);
            if (m > target){
                hi=mid-1;
            }else if (m < target){
                lo=mid+1;
            }else{
                return mid;
            }
        }
        lo=top;
        hi=A.length()-1;
        while(lo <= hi){
            int mid = (lo+hi)>>1;
            int m = A.get(mid);
            if (m > target){
                lo=mid+1;
            }else if (m < target){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
