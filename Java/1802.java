class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int lo = maxSum / n, hi = maxSum;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2 + 1;
            if (ok(mid, n, index, maxSum)) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }

    private boolean ok(int guess, long n, long idx, long maxSum){
        long last = guess - (n - 1 - idx) > 0? guess - (n - 1 - idx) : 1;
        long first= guess - idx > 0? guess - idx : 1;
        long forward = (guess + last) * (guess - last + 1) / 2 + (n - Math.min(n, idx + guess));
        long backward= (guess + first)* (guess - first+ 1) / 2 + (Math.max(0, idx - guess + 1) - 0);
        long sum = forward + backward - guess;
        return sum <= maxSum;
    }
}
