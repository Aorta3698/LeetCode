class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]){
                ans[i]++;
                stack.pop();
            }
            if (!stack.isEmpty()){
                ans[i]++;
            }
            stack.push(i);
        }
        return ans;
    }
}
