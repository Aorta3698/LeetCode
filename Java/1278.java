class Solution {
    public int palindromePartition(String S, int k) {
        int n = S.length();
        int[] dp = new int[n];
        int[][] pre = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int a=i,b=j;
                while(a<b){
                    if (S.charAt(a++)!=S.charAt(b--)){
                        pre[i][j]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            dp[i]=pre[0][i];
        }
        for (int i = 1; i<k; i++){
            for (int j = n-1; j >= 0; j--){
                dp[j]=100000;
                for (int s = j; s >= i; s--){
                    dp[j]=Math.min(dp[j], pre[s][j]+dp[s-1]);
                }
            }
        }

        return dp[n-1];
    }
}
