https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/2271020/Java-or-Top-Down-DP
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return solve(0, n, 0, cuts.length-1, cuts, new int[cuts.length][cuts.length]);
    }

    private int solve(int low, int high, int lo, int hi, int[] cuts, int[][] memo){
        if (lo>hi){
            return 0;
        }
        if (memo[lo][hi]>0){
            return memo[lo][hi];
        }
        int ans = (int)1e9;
        for (int i = lo; i <= hi; i++){
            int cost = high-low+solve(low,cuts[i],lo,i-1,cuts,memo)+solve(cuts[i],high,i+1,hi,cuts,memo);
            ans = Math.min(ans, cost);
        }
        return memo[lo][hi]=ans;
    }
}
