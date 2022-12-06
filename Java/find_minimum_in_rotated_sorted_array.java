class Solution {
    public int findMin(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) hi = mid;
            else if (nums[mid] >= nums[lo]) lo = mid + 1;
        }

        return nums[hi];
    }
}
