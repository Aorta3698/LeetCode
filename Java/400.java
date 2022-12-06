class Solution {
    public int findNthDigit(int target) {
        int lo = 0, hi = Integer.MAX_VALUE - 1;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            if (get(mid) < target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        target -= get(lo);
        return String.valueOf(lo + 1).charAt(target - 1) - '0';
    }

    private long get(int n){
        long sum = 0;
        int m = n, d = 0;
        while(m > 0){
            m /= 10;
            d++;
        }
        for (int i = d - 1; i > 0; i--){
            sum = 10 * sum + 9 * i;
        }

        sum += 1L * d * (n - 1L * Math.pow(10, d - 1) + 1);
        return sum;
    }
}
