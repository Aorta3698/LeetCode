class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix[0].length, m = matrix.length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = matrix[i][j];
                }else if (i == 0){
                    dp[i][j] = matrix[i][j] ^ dp[i][j - 1];
                }else if (j == 0){
                    dp[i][j] = matrix[i][j] ^ dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                }
                minheap.offer(dp[i][j]);
                if (minheap.size() > k){
                    minheap.poll();
                }
            }
        }

        return minheap.peek();
    }
}
