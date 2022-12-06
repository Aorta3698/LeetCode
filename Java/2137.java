class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double lo = 0, hi = 100000;
        while(hi - lo > 1e-5){
            double mid = (lo + hi) / 2;
            if (ok(buckets, loss, mid)) lo = mid;
            else hi = mid;
        }
        return lo;
    }

    private boolean ok(int[] buckets, int loss, double guess){
        double above = 0, below = 0;
        for (int n : buckets){
            above += Math.max(0, n - guess);
            below += Math.max(0, guess - n);
        }
        return (100 - loss) * above >= 100 * below;
    }
}
