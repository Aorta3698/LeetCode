class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + nums.length - i > k){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < ans.length; i++){
            ans[i] = stack.pollLast();
        }
        return ans;
    }
}
