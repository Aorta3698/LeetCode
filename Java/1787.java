https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/discuss/2338622/Sharing-My-Java-Solution-or-Explained.
class Solution {
    public int minChanges(int[] nums, int K) {
        int INF = (int)1e9, A = 1<<10;
        BitSet[] bit = new BitSet[K];
        Arrays.setAll(bit, o -> new BitSet());
        int[][] count = new int[K][A];
        int[] ttl = new int[K];
        for (int i = 0; i < nums.length; i++){
            bit[i%K].set(nums[i]);
            count[i%K][nums[i]]++;
            ttl[i%K]++;
        }
        int[] dp = new int[A];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for (int i = 0; i < K; i++){
            int[] ndp = new int[dp.length];
            int min = Arrays.stream(dp).min().getAsInt() + ttl[i];
            Arrays.fill(ndp, min);
            for (int j = 0; j < A; j++){ // mask
                for (int k = bit[i].nextSetBit(0); k >= 0; k = bit[i].nextSetBit(k+1)){
                    ndp[j]=Math.min(ndp[j], ttl[i] - count[i][k] + dp[j^k]);
                }
            }
            dp=ndp;
        }

        return dp[0];
    }
}
