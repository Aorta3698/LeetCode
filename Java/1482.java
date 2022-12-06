class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int lo = 1, hi = 1000000000;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (ok(mid, m, k, bloomDay)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean ok(int guess, int m, int k, int[] arr){
        int cnt = 0, adj = 0;
        for (int n : arr){
            if (guess >= n && ++adj == k){
                cnt++;
                adj = 0;
            }
            if (guess < n) adj = 0;
        }

        return cnt >= m;
    }
}
