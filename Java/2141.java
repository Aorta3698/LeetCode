https://leetcode.com/problems/maximum-running-time-of-n-computers/discuss/2348006/Java-or-Binary-Search-or-Explained.
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long lo = 0, hi = (long)1e14;
        while(lo < hi){
            long mid = (lo+hi+1)>>1;
            long sum = 0;
            int count = 0;
            for (int b : batteries){
                sum += Math.min(b, mid);
                if (sum >= mid){
                    sum -= mid;
                    count++;
                }
            }
            if (count >= n){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
