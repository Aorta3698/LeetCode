class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        Map<Long, Integer>[] dp = new HashMap[nums.length];
        Arrays.setAll(dp, o -> new HashMap<>());
        for (int i = 0; i < nums.length; i++){
            for (int j = i-1; j >= 0; --j){
                long diff = 0L+nums[i]-nums[j];
                int cur = dp[j].getOrDefault(diff, 1)+1;
                ans += Math.max(cur-2, 0);
                if (dp[i].containsKey(diff)){
                    --cur;
                }
                dp[i].merge(diff, cur, Integer::sum);
            }
        }
        return ans;
    }
}
