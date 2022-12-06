class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1')
                    dp[i][j] = dp[Math.max(i - 1, 0)][j] + matrix[i][j] - '0';

        for (int[] d : dp){
            ArrayDeque<Integer> stack = new ArrayDeque<>(List.of(-1));
            for (int i = 0; i < n; i++){
                while(stack.peek() >= 0 && d[i] < d[stack.peek()]){
                    int val = d[stack.pop()];
                    int dist= i - stack.peek() - 1;
                    ans = Math.max(val * dist, ans);
                }
                stack.push(i);
            }

            while(stack.peek() >= 0){
                int val = d[stack.pop()];
                int dist= n - stack.peek() - 1;
                ans = Math.max(val * dist, ans);
            }
        }

        return ans;
    }
}
