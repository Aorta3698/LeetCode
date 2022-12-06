class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = 0, pre = 0;
        for (; end < nums.length; end++){
            pre += nums[end];
            if (nums[end] * (end - start + 1) - pre > k){
                pre -= nums[start++];
            }
        }

        return end - start;
    }
}
