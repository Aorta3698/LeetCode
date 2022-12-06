class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0, n = piles.length;
        for (int p : piles){
            lo = Math.min(lo, p);
            hi = Math.max(hi, p);
        }
        lo = Math.max((int)((long)lo * n / h), 1);

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (ok(mid, h, piles)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean ok(int guess, int minHr, int[] arr){
        int cnt = 0;
        for (int n : arr){
            cnt += n / guess;
            cnt += Integer.signum(n % guess);
        }

        return cnt <= minHr;
    }
}
