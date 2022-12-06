https://leetcode.com/problems/profitable-schemes/discuss/2253885/Java-or-I-spent-1-hr-debugging-lol-or-DP
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int M = (int)1e9+7, ans = 0, N = minProfit;
        int[][] dp = new int[n+1][N+1];
        dp[0][0]=1;
        for (int i = 0; i < group.length; i++){
            for (int j = N; j >= 0; --j){
                for (int k = n-group[i]; k >= 0; --k){
                    dp[k+group[i]][Math.min(N, j+profit[i])]+=dp[k][j];
                    dp[k+group[i]][Math.min(N, j+profit[i])]%=M;
                }
            }
        }
        for (int i = 0; i <= n; i++){
            ans += dp[i][N];
            ans %= M;
        }
        return ans;
    }
}

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int M = (int)1e9+7, ans = 0;
        int[][] dp = new int[n+1][101];
        dp[0][0]=1;
        for (int i = 0; i < group.length; i++){
            int[][] next = new int[n+1][101];
            for (int j = 0; j <= n; j++){
                next[j]=dp[j].clone();
            }
            for (int j = 0; j <= 100; j++){
                for (int k = 0; k <= n-group[i]; k++){
                    next[k+group[i]][Math.min(100, j+profit[i])]+=dp[k][j];
                    next[k+group[i]][Math.min(100, j+profit[i])]%=M;
                }
            }
            dp=next;
        }
        for (int i = 0; i <= n; i++){
            for (int j = minProfit; j <= 100; j++){
                ans += dp[i][j];
                ans %= M;
            }
        }
        return ans;
    }
}
