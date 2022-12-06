class Solution {
    public int findKthNumber(int m, int n, int k) {
        int hi = m*n;
        int lo = 1;
        k = m*n - k + 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int bCount = countBigger(mid, m, n);
            if (bCount >= k) lo = mid + 1;
            else hi = mid;
        }

        return hi;
    }

    private int countBigger(int num, int r, int c){
        int sum = 0;
        for (int i = 1; i <= c; i++)
            sum += Math.max(r - num / i, 0);
        return sum;
    }
}
