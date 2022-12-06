class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = Long.MAX_VALUE;
        while(lo < hi){
            long mid = lo + (hi - lo) / 2;
            long sum = 0;
            for (int t : time){
                sum += mid / t;
                if (sum >= totalTrips) break;
            }
            if (sum >= totalTrips) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
