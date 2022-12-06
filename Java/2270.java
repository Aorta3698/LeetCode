class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        long pre = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++){
            pre += nums[i];
            sum -= nums[i];
            if (pre >= sum){
                ++ans;
            }
        }
        return ans;
    }
}
