class Solution {
    public boolean isPowerOfThree(int n) {
        int lo = 0, hi = 30;
        while(lo < hi){
            int mid = (lo+hi)>>1;
            long cur = (long)Math.pow(3, mid);
            if (cur >= n){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return Math.pow(3, lo) == n;
    }
}
