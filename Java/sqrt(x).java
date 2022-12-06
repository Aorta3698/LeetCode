class Solution {
    public int mySqrt(int x) {
        long hi = x;
        long lo = 0;
        while (lo <= hi){
            long mid = lo + (hi - lo) / 2;
            if (mid*mid <= x && (mid+1)*(mid+1) > x ) return (int)mid;
            if (mid*mid < x) lo = mid + 1;
            if (mid*mid > x) hi = mid - 1;
        }

        return -1;
    }
}
