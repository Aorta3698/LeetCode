class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if (nums[mid] >= target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if (nums.length==0||nums[lo]!=target){
            return ans;
        }
        ans[0]=lo;
        lo=0;
        hi=nums.length-1;
        while(lo < hi){
            int mid = (lo+hi+1)>>1;
            if (nums[mid] <= target){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        ans[1]=lo;
        return ans;
    }
}
