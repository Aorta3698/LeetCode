class Solution {
    public long minimumPerimeter(long neededApples) {
        long lo = 0, hi = (long)1e7;
        while(lo < hi){
            long mid = (hi + lo) >> 1;
            long sum = 1L * (mid + 1) * mid * (2*mid + 1) + 1L * (mid + 1) * mid * (mid * 2 + 1);

            if (sum >= neededApples){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return 1L * 2 * lo * 4;
    }
}


//
//    4   3   2   3   4
//    3   2   1   2   3
//    2   1   0   1   2
//    3   2   1   2   3
//    4   3   2   3   4
//
