https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/discuss/2269438/Java-or-Only-arrange-1-array-or-Bottom-up-DP
class Solution {
    public int minimumXORSum(int[] A, int[] B) {
        int N = 1 << A.length, INF = (int)1e9;
        int[] dp =  new int[N];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < A.length; j++){
                if ((i & 1<<j)==0){
                    int sum = (A[j]^B[Integer.bitCount(i)]) + dp[i];
                    dp[i|1<<j]=Math.min(sum, dp[i|1<<j]);
                }
            }
        }
        return dp[N-1];
    }
}
