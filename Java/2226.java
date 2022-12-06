https://leetcode.com/problems/maximum-candies-allocated-to-k-children/discuss/1908925/Java-or-Binary-Search
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo = 0, hi = (int)1e7;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            long get = 0;
            for (int i = 0; i < candies.length; i++){
                get += candies[i] / mid;
            }
            if (get >= k){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }

        return lo;
    }
}
