https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/1657845/Java-100-5ms-Binary-Search-Thinking-Process
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = -1, hi = -1, sum = 0;
        for (int w : weights){
            sum += w;
            lo = Math.max(lo, w);
        }

        hi = lo * (weights.length / days + Integer.signum(weights.length % days));
        lo = Math.max(lo, sum / days);
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (isOK(mid, weights, days)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean isOK(int c, int[] arr, int d){
        int sum = 0;
        for (int n : arr){
            if (sum + n > c){
                sum = 0;
                d--;
            }
            sum += n;
        }

        return d > 0;
    }
}
