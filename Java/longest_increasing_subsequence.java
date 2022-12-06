class Solution {
    public int lengthOfLIS(int[] nums) {
        //f(n) = max(f(n-i) + 1) where nums[n-i] < nums[n]
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) dp[i] = 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
