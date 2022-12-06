https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/1659379/Java-Binary-Search-Scale-it-from-0-to-1013-or-99-Speed.
class Solution {
    double unit = 0.000001;
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        long lo = 0, hi = (long)1e13;

        while(lo < hi){
            long mid = lo + (hi - lo) / 2;
            if (ok(mid, k, stations)) hi = mid;
            else lo = mid + 1;
        }

        return lo*unit;
    }

    private boolean ok(long guess, long k, int[] arr){
        int cnt = 0;
        for (int i = 1; i < arr.length; i++){
            double d = arr[i] - arr[i - 1];
            cnt += d / (guess * unit);

            // double d = arr[i] - arr[i - 1];
            // if (d > guess * unit){
            //     int n = (int)(d / (guess * unit));
            //     cnt += n;
            //     if (n * guess * unit == d) cnt--;
            // }
        }

        return cnt <= k;
    }
}
