class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 0, hi = 0, m = quantities.length;
        long sum = 0;
        for (int q : quantities){
            hi = Math.max(q, hi);
            sum += q;
        }
        lo = Math.max((int)(sum / n), 1);

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (ok(mid, n, quantities)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean ok(int guess, int stores, int[] arr){
        int cnt = 0;
        for (int n : arr){
            cnt += n / guess;
            cnt += Integer.signum(n % guess);
        }

        return cnt <= stores;
    }
}
