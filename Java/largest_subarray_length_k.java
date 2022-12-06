class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int[] ans = new int[k];
        int midx = 0;
        for (int i = 1; i < nums.length - k + 1; i++)
            if (nums[i] > nums[midx])
                midx = i;
        while(--k >= 0)
            ans[ans.length - k - 1] = nums[midx++];

        return ans;
    }
}
