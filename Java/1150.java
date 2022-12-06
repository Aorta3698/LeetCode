class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int start = binarySearch(0, n, nums, target);
        int end = binarySearch(0, n, nums, target + 1);
        return end - start > n / 2;
    }

    private static int binarySearch(int lo, int hi, int[] nums, int target){
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
