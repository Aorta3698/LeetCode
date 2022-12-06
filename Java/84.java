class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(List.of(-1));
        int ans = 0;
        for (int i = 0; i < heights.length; i++){
            while(stack.peek() >= 0 && heights[i] < heights[stack.peek()]){
                int val = heights[stack.pop()];
                int dist= i - stack.peek() - 1;
                ans = Math.max(val * dist, ans);
            }
            stack.push(i);
        }

        while(stack.peek() >= 0){
            int val  = heights[stack.pop()];
            int dist = heights.length - stack.peek() - 1;
            ans = Math.max(val * dist, ans);
        }

        return ans;
    }
}
