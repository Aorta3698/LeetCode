class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[nums.length][sum * 2 + 1];
        //dp[i - 1][x] -> dp[i][x + nums[i]]
        //dp[i - 1][x] -> dp[i][x - nums[i]]
        dp[0][sum - nums[0]] = 1;
        dp[0][sum + nums[0]] += 1;

        for (int i = 1; i < dp.length; i++){
            for (int s = -sum; s <= sum; s++){
                if (dp[i - 1][s + sum] > 0){
                    dp[i][s + sum + nums[i]] += dp[i - 1][s + sum];
                    dp[i][s + sum - nums[i]] += dp[i - 1][s + sum];
                }
            }
        }

        for(int[] d : dp)
            System.out.println(Arrays.toString(d));

        return dp[nums.length - 1][sum + target];
    }
}
