class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] pre = new int[nums.length + 1], ans = new int[nums.length];
        for (int i = 1; i <= nums.length; i++) pre[i] = pre[i - 1] + nums [i - 1];
        for (int i = 0; i < nums.length; i++){
            int forward = pre[nums.length] - pre[i] - nums[i] * (nums.length - i);
            int backward= nums[i] * i - pre[i];
            ans[i] = forward + backward;
        }

        return ans;
    }
}
