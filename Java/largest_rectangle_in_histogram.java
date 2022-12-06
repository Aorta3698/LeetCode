class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[i] < stack.peek()[0]){
                int[] rect = stack.pop();
                int dis = stack.isEmpty()? i : i - stack.peek()[1] - 1;
                max = Math.max(rect[0]*dis, max);
            }
            stack.push(new int[]{heights[i], i});
        }

        while(!stack.isEmpty()){
            int[] rect = stack.pop();
            int dis = stack.isEmpty()? heights.length : heights.length - stack.peek()[1] - 1;
            max = Math.max(rect[0]*dis, max);
        }

        return max;
    }
}
