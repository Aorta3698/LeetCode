class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++){
            int next = Math.max(prev + nums[i], cur);
            prev = cur;
            cur = next;
        }

        return cur;
    }
}
