class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1000000;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (ok(mid, nums, threshold)) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    private boolean ok(int guess, int[] nums, int threshold){
        int sum = 0;
        for(int n : nums) {
            sum += n / guess;
            sum += Integer.signum(n % guess);
        }
        return sum > threshold;
    }
}
