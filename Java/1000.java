class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n-1)%(k-1)!=0){
            return -1;
        }
        int[][] dp = new int[n][n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++){
            pre[i]=i==0?stones[i]:stones[i]+pre[i-1];
        }
        for (int i = n-1; i >= 0; --i){
            for (int j = i+1; j < n; j++){
                dp[i][j]=(int)1e9;
                for (int m = i; m < j; m+=k-1){
                    dp[i][j]=Math.min(dp[i][j], dp[i][m]+dp[m+1][j]);
                }
                if ((j-i)%(k-1)==0){
                    dp[i][j] += pre[j]-(i==0?0:pre[i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
