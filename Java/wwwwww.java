class Solution {
    // constraint: 0 < A[i] < 1000000000
    //             n = A.length
    //             0 < n <= 100000

    private int findMinMax(int[] A){
        int lo = 1, hi = (int)1e9;
        while(lo < hi){
            int mid = (lo+hi)>>1, i = 0;
            long avail = 0;
            for (; i < A.length && avail >= 0; i++){
                avail += mid-A[i];
            }
            if (i == A.length){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
}
