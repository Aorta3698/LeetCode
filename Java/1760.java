class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = (int)1e9;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            int need = 0;
            for (int n : nums){
                need += (n - 1) / mid;
            }
            if (need <= maxOperations){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}
