class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long[] pre = new long[nums.length];
        for (int i = 0; i < nums.length; i++){
            pre[i] = i == 0? nums[i] : nums[i]+pre[i-1];
        }
        for (int i = 0; i < nums.length; i++){
            int lo = i, hi = nums.length;
            while(lo < hi){
                int mid = (lo + hi) >> 1;
                long sum = i == 0? pre[mid] : pre[mid]-pre[i-1];
                if (sum * (mid-i+1)>=k){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            ans += lo-i;
        }
        return ans;
    }
}
