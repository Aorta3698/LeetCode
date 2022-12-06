https://leetcode.com/problems/k-inverse-pairs-array/discuss/2292322/Java-or-from-O(nkk)-to-O(nk)
class Solution {
    public int kInversePairs(int n, int k) {
        int M = (int)1e9+7;
        int[] dp = new int[k+1];
        dp[0]=1;
        for (int i = 2; i <= n; i++){
            int[] ndp = new int[k+1];
            for (int p = 0, pre=0; p <= k; p++){
                if (p>=i){
                    pre=M+pre-dp[p-i];
                    pre%=M;
                }
                pre+=dp[p];
                pre%=M;
                ndp[p]+=pre;
                ndp[p]%=M;
            }
            // for (int j = i-1; j >= 0; j--){
            //     for (int p = 0; p+j <= k; p++){
            //         dp[i][p+j]+=dp[i-1][p];
            //         dp[i][p+j]%=M;
            //     }
            // }
            dp=ndp;
        }
        return dp[k];
    }
}
