class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int N = 1<<2*numSlots, ans = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++){
            for (int j = 0,a=Integer.bitCount(i); j < 2*numSlots&&a<nums.length; j++){
                if ((i&1<<j)==0){
                    int sum = (nums[a]&(j/2+1))+dp[i];
                    dp[i|1<<j]=Math.max(dp[i|1<<j], sum);
                    if (a == nums.length-1){
                        ans=Math.max(ans, dp[i|1<<j]);
                    }
                }
            }
        }
        return ans;
    }
}
