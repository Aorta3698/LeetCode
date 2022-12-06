class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '('){
                dp[i] = (stack.peek() == 0? 0 : dp[stack.peek() - 1]) + i - stack.pop() + 1;
                ans = Math.max(dp[i], ans);
            }else{
                stack.push(i);
            }
        }

        return ans;
    }
}
