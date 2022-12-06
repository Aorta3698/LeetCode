https://leetcode.com/problems/make-array-non-decreasing-or-non-increasing/discuss/2289201/Java-or-DP-5-lines-or-Explained.
class Solution {
    public int convertArray(int[] nums) {
        return Math.min(solve(nums), solve(Arrays.stream(nums).map(o -> -o+1000).toArray()));
    }

    private int solve(int[] nums){
        int[] dp = new int[1001];
        for (int n : nums){
            for (int j = 0, min=(int)1e9; j <= 1000; j++){
                min = dp[j] = Math.min(min, Math.abs(j-n)+dp[j]);
            }
        }
        return dp[1000];
    }
}
