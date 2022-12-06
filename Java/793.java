class Solution {
    public int preimageSizeFZF(int k) {
        // x/5 + x/25 + x/125 + ... = k
        long lo = 0, hi = (long)1e12;
        while(lo <= hi){
            long mid = (lo+hi) >> 1;
            long sum = 0, n = mid;
            while(n > 0){
                sum += n/5;
                n/=5;
            }
            if (sum > k){
                hi = mid-1;
            }else if (sum < k){
                lo = mid+1;
            }else{
                return 5;
            }
        }
        return 0;
    }

}
