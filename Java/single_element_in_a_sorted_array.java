class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        return find(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (mid == 0) return nums[mid] == nums[mid+1]? -1 : nums[mid];
        if (mid == nums.length - 1) return nums[mid] == nums[mid-1]? -1 : nums[mid];
        if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
        int r = find(nums, mid + 1, hi);
        int l = find(nums, lo, mid - 1);

        return r == -1? l : r;
    }
}
