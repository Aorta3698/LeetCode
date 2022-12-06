https://leetcode.com/problems/maximum-of-minimum-values-in-all-subarrays/discuss/1938972/This-is-the-hardest-monostack-medium-problem
class Solution {
    public int[] findMaximums(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < nums.length; i++){
            while(stack.size() > 1 && nums[i] < nums[stack.peek()]){
                int j = stack.pop(), sz = i - stack.peek() - 2;
                ans[sz] = Math.max(ans[sz], nums[j]);
            }
            stack.push(i);
        }

        while(stack.size() > 1){
            int j = stack.pop(), sz = nums.length - stack.peek() - 2;
            ans[sz] = Math.max(ans[sz], nums[j]);
        }

        for (int i = ans.length - 2; i >= 0; i--){
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return ans;
    }
}
