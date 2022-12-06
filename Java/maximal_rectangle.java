class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (matrix[i][j] == '1')
                    dp[i][j] = dp[Math.max(0, i - 1)][j] + 1;

        int max = 0;
        for (int[] heights : dp){
            Stack<int[]> stack = new Stack<>();
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
        }

        return max;
    }
}
