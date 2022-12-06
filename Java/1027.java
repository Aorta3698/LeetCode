class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0, n = nums.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int k = map.getOrDefault(2 * nums[i] - nums[j], -1);
                if (k == -1) continue;
                dp[i][j] = dp[k][i] + 1;
                ans = Math.max(dp[i][j], ans);
            }
            map.put(nums[i], i);
        }
        // for (int[] d : dp){
        //     System.out.println(Arrays.toString(d));
        // }

        return ans + 2;
    }
}
