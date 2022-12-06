class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if (nums[mid]>=target){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
}
