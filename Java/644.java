https://leetcode.com/problems/maximum-average-subarray-ii/discuss/2381194/Java-or-Short-Binary-Search
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double lo = -10000, hi = 10000;
        while(hi-lo > 0.00001){
            double mid = (lo+hi)/2, sum = 0, min = Double.MAX_VALUE;
            Queue<Double> queue = new ArrayDeque<>();
            queue.offer(0.);
            boolean ok = false;
            for (int n : nums){
                sum += n-mid;
                if (queue.size() == k){
                    min = Math.min(min, queue.poll());
                }
                queue.offer(sum);
                ok |= sum-min >= 0;
            }
            if (ok){
                lo=mid;
            }else{
                hi=mid;
            }
        }
        return lo;
    }
}
