class Solution {
    public int[] findBuildings(int[] heights) {
        int max = 0;
        int count = 0;
        for (int i = heights.length-1; i >= 0; i--){
            if (heights[i]>max){
                max = heights[i];
                heights[heights.length-1-count++] = i;
            }
        }

        return Arrays.copyOfRange(heights, heights.length-count, heights.length);
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i<heights.length; i++){
        //     while(!stack.isEmpty()&&heights[i]>=heights[stack.peek()])stack.pop();
        //     stack.push(i);
        // }

        // int size = stack.size();
        // int[] ans = new int[size];
        // while(!stack.isEmpty())
        //     ans[--size]=stack.pop();

        // return ans;
    }
}
