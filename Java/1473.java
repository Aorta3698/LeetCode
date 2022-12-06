https://leetcode.com/problems/paint-house-iii/discuss/2254299/Java-or-2D-DP-or-Bottom-up
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int T) {
        int INF = (int)1e9, ans = INF;
        int[][] dp = new int[T+2][n+1]; // num of neighorhood, colors
        for (int i = 1; i <= n; i++){
            if (houses[0]==0){
                dp[1][i]=cost[0][i-1];
            }else if (houses[0]!=i){
                dp[1][i]=INF;
            }
        }
        for (int i = 1; i < m; i++){
            int[][] next = new int[T+2][n+1];
            for (int j = 0; j <= T; j++){
                Arrays.fill(next[j], INF);
            }
            for (int j = 1; j <= Math.min(T, i); j++){ // num of neighborhood
                for (int k = 1; k <= n; k++){ // current color
                    if (houses[i]>0){
                        int v = k == houses[i]?0:1;
                        next[j+v][houses[i]]=Math.min(next[j+v][houses[i]], dp[j][k]);
                        continue;
                    }
                    if (houses[i-1]!=0){
                        int v = houses[i-1]==k?0:1;
                        next[j+v][k]=Math.min(next[j+v][k], dp[j][houses[i-1]]+cost[i][k-1]);
                        continue;
                    }
                    for (int p = 1; p <= n; p++){ // previous color
                        int v = p == k? 0 : 1;
                        next[j+v][k]=Math.min(next[j+v][k], dp[j][p]+cost[i][k-1]);
                    }
                }
            }
            dp=next;
        }
        for (int i = 0; i <= n; i++){
            ans = Math.min(dp[T][i], ans);
        }
        return ans==INF?-1:ans;
    }
}
