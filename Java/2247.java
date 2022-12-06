https://leetcode.com/problems/maximum-cost-of-trip-with-k-highways/discuss/2181795/2-Codes-or-Bottom-up-Top-Down-DP-or-45ms-or-Java
class Solution {
    public int maximumCost(int n, int[][] highways, int k) {
        int[][] cost = new int[n][n];
        int[][] dp = new int[n][1<<n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
            Arrays.fill(cost[i], -1);
        }
        for (int[] h : highways){
            cost[h[0]][h[1]]=cost[h[1]][h[0]]=h[2];
        }
        for (int i = 0; i < n; i++){
            dp[i][1<<i]=0;
        }

        int ans = -1;
        for (int bits = 1; bits <= k && k < n; bits++){
            for (int mask = (1<<bits)-1; mask < 1<<n; mask=nextMask(mask)){
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n && dp[i][mask]>=0; j++){
                        if (cost[i][j]>=0 && (mask & (1<<j)) == 0){
                            int nMask = mask|(1<<j);
                            dp[j][nMask]=Math.max(dp[j][nMask], dp[i][mask]+cost[i][j]);
                            if (bits==k){
                                ans = Math.max(dp[j][nMask], ans);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    private int nextMask(int mask){
        int t = (mask | (mask - 1)) + 1;
        return t | ((((t & -t) / (mask & -mask)) >> 1) - 1);
    }
}

// class Solution {
//     public int maximumCost(int n, int[][] highways, int k) {
//         Map<Integer, List<int[]>> map = new HashMap<>();
//         int[][] cost = new int[n][n];
//         for (int i = 0; i < n; i++){
//             Arrays.fill(cost[i], -1);
//         }
//         for (int[] h : highways){
//             cost[h[0]][h[1]]=cost[h[1]][h[0]]=h[2];
//         }
//         Integer[][] memo = new Integer[1<<n][n];
//         int ans = -1;
//         for (int i = 0; i < n && k < n; i++){
//             ans = Math.max(ans, dfs(i, 1<<i, k, memo, cost));
//         }
//         return ans;
//     }

//     private int dfs(int i, int seen, int k, Integer[][] memo, int[][] cost){
//         if (k==0)
//             return 0;
//         if (memo[seen][i]!=null)
//             return memo[seen][i];

//         int ans = -10000000;
//         for (int j = 0; j < cost.length; j++){
//             if (cost[i][j]>=0 && (seen & (1<<j))==0){
//                 ans = Math.max(ans, cost[i][j]+dfs(j, seen|(1<<j), k-1, memo, cost));
//             }
//         }

//         return memo[seen][i]=ans;
//     }
// }
