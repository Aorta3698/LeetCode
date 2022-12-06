https://leetcode.com/problems/maximize-score-after-n-operations/discuss/2267002/Java-or-Bottom-up-1D-DP
class Solution {
    public int maxScore(int[] nums) {
        int N = 1 << nums.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++){
            for (int j = 0,a=Integer.bitCount(i); j < nums.length && a%2==0; j++){
                for (int k = 0; k < nums.length&&(i&(1<<j))==0; k++){
                    if ((i&1<<k)==0){
                        int mask = i | 1<<j | 1<<k;
                        dp[mask]=Math.max(dp[mask],dp[i]+(a/2+1)*gcd(nums[j], nums[k]));
                    }
                }
            }
        }
        return dp[N-1];
    }

    private int gcd(int a, int b){
        return a==0?b:gcd(b%a,a);
    }
}
