class Solution {
    public int validSubarrays(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i >= 0; i--){
            int j = 0;
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                j = stack.pop();
                dp[i] += dp[j];
            }

            stack.push(i);
        }

        return Arrays.stream(dp).sum();
    }
}
