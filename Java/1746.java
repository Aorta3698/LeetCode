class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int sq = 0, sum = 0, ans = 0;
        for (int n : nums){
            sq = Math.max(sq + n, sum + n * n);
            sum = Math.max(sum + n, 0);
            ans = Math.max(ans, sq);
        }

        return ans;
    }
}
