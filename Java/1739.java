class Solution {
    public int minimumBoxes(int n) {
        //1, 3, 6, 10, ..., k
        //1, 1+2, 3+3, 6+4, ..., k
        //1, 1+2, 1+2+3, 1+2+3+4, 1+2+3+4+5, ...,  (k elements)
        //1/2 * (sum of n^2 from 1 to k + sum of n from 1 to k)

        int lo = 1, hi = 2000;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            if (total(mid) <= n){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }

        long remain = n - total(lo), ans = total(lo) - total(lo - 1);
        lo = 0; hi = 20000;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if ((mid+1)*mid/2 >= remain){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return (int)(ans + lo);
    }

    private long total(int lvl){
        return (1L*lvl*(lvl+1)*(2*lvl+1)/6+1L*lvl*(lvl+1)/2)/2;
    }
}
