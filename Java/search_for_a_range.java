class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0 || nums == null) return ans;

        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            if (nums[mid] < target) lo = mid + 1;
        }
        if (nums[hi] != target) return ans;
        ans[0] = hi;

        lo = hi;
        hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) lo = mid + 1;
            if (nums[mid] != target) hi = mid;
        }
        ans[1] = nums[hi] == target? hi : hi - 1;

        return ans;
    }
}
