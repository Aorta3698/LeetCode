https://leetcode.com/problems/count-ways-to-distribute-candies/discuss/2257204/From-struggling-to-AC-or-Java
class Solution {
    public int waysToDistribute(int n, int k) {
        int M = (int)1e9+7;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < k; i++){
            long[] next = new long[n];
            for (int j = 1; j < n; j++){
                next[j]=((i+1)*next[j-1]+dp[j-1])%M;
            }
            dp=next;
        }
        return (int)dp[n-1];
    }
}

// class Solution {
//     public int waysToDistribute(int n, int k) {
//         if (n==1){
//             return 1;
//         }
//         int M = (int)1e9+7;
//         long[] fact = new long[n+1];
//         long[] inv = new long[n+1];
//         long[] factinv = new long[n+1];
//         fact[0]=fact[1]=factinv[0]=factinv[1]=inv[1]=1;
//         for (int i = 2; i <= n; i++){
//             inv[i]=M-M/i*inv[M%i]%M;
//             fact[i]=fact[i-1]*i%M;
//             factinv[i]=factinv[i-1]*inv[i]%M;
//         }

//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         for (int i = 1; i < k; i++){
//             for (int j = n-1; j >= 0; j--){
//                 dp[j]=0;
//                 for (int m = j-1,v=0; m >= i-1; m--,v++){
//                     dp[j]+=dp[m]*fact[j]%M*factinv[v]%M*factinv[j-v]%M;
//                     dp[j]%=M;
//                 }
//             }
//         }
//         return dp[n-1];
//     }
// }

// class Solution {
//     int M = (int)1e9+7;
//     public int waysToDistribute(int n, int k) {
//         if (n==1){
//             return 1;
//         }
//         long[] fact = new long[n+1];
//         long[] inv = new long[n+1];
//         long[] factinv = new long[n+1];
//         fact[0]=fact[1]=factinv[0]=factinv[1]=inv[1]=1;
//         for (int i = 2; i <= n; i++){
//             inv[i]=M-M/i*inv[M%i]%M;
//             fact[i]=fact[i-1]*i%M;
//             factinv[i]=factinv[i-1]*inv[i]%M;
//         }
//         return solve(0, 0, n, new int[k], fact, factinv);
//     }

//     private int solve(int idx, int cur, int n, int[] groups, long[] fact, long[] factinv){
//         if (cur == n){
//             long ans = fact[n] * factinv[groups.length] % M;
//             for (int i = 0; i < groups.length; i++){
//                 ans *= factinv[groups[i]];
//                 ans %= M;
//             }
//             return (int)ans;
//         }
//         if (idx==groups.length-1){
//             groups[idx]=n-cur;
//             return solve(idx+1, n, n, groups,fact,factinv);
//         }
//         int ans = 0;
//         for (int i = cur; i < n-(groups.length-1-idx); i++){
//             groups[idx]++;
//             ans += solve(idx+1, i+1, n, groups, fact, factinv);
//             ans %= M;
//         }
//         groups[idx]=0;
//         return ans;
//     }
// }
