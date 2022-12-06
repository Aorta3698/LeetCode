class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int r = Integer.MAX_VALUE / 2, n = nums.length;
        for (int i = start; i < n && r > n; i++)
            if (nums[i] == target)
                r = i;

        for (int i = start; i >= 0; i--)
            if (nums[i] == target)
                return Math.min(start - i, r - start);

        return r - start;
    }
}
