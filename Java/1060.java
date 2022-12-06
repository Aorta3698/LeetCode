class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length, missing = getMissing(nums, n - 1);
        if (k > missing){
            return nums[n - 1] + k - missing;
        }

        int lo = 0, hi = n - 1;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            missing = getMissing(nums, mid);
            if (missing < k) lo = mid;
            else hi = mid - 1;
        }

        return nums[lo] + k - getMissing(nums, lo);
    }

    private int getMissing(int[] nums, int idx){
        return nums[idx] - nums[0] + 1 - (idx + 1);
    }
}
