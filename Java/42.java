class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int cur = stack.pop();
                if (stack.isEmpty())
                    break;
                int width = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[cur];
                ans += width * h;
            }
            stack.push(i);
        }
        return ans;
    }
}
