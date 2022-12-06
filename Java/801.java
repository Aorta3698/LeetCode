https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/2306079/Java-O(N)-O(1)-or-Swap-or-Not-Swap
class Solution {
    public int minSwap(int[] A, int[] B) {
        int[] dp = new int[]{0, 1};
        int INF = (int)1e9;
        for (int i = 1; i < A.length; i++){
            int[] ndp = new int[2];
            ndp[0]=Math.min(A[i]>A[i-1]&&B[i]>B[i-1]?dp[0]:INF, A[i]>B[i-1]&&B[i]>A[i-1]?dp[1]:INF);
            ndp[1]=Math.min(B[i]>B[i-1]&&A[i]>A[i-1]?dp[1]:INF, B[i]>A[i-1]&&A[i]>B[i-1]?dp[0]:INF)+1;
            dp=ndp;
        }
        return Math.min(dp[0], dp[1]);
    }
}
