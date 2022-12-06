class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            if (nums[mid] < target) lo = mid + 1;
            if (nums[mid] == target) return mid;
        }

        return -1;
    }
}
