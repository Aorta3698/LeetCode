class Solution {
    public int reversePairs(int[] nums) {
        int ans = 0;
        int[] bit = new int[nums.length+2];
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++){
            ans += i - sum(bit, bs(sorted, 2L*nums[i]));
            update(bit, bs(sorted, nums[i]), 1);
        }
        return ans;
    }

    private int bs(int[] sorted, long target){
        int lo = 0, hi = sorted.length;
        while(lo < hi){
            int mid = (lo+hi) >> 1;
            if (sorted[mid] > target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    private void update(int[] bit, int idx, int inc){
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx] += inc;
        }
    }

    private int sum(int[] bit, int idx){
        int ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}
