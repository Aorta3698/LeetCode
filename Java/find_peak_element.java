class Solution {
    public int findPeakElement(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;

        while(hi > lo){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid+1]) lo = mid + 1;
            else hi = mid;
        }

        return hi;
    }
}
