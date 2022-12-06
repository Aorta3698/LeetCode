class Solution {
    public int minimumAverageDifference(int[] nums) {
        long min = Long.MAX_VALUE, suffix = Arrays.stream(nums).asLongStream().sum(), prefix = 0, ans = 0;
        for (int i = 0; i < nums.length; i++){
            prefix += nums[i];
            suffix -= nums[i];
            long d = Math.abs(prefix/(i + 1) - (i == nums.length - 1? 0 : suffix/(nums.length - (i + 1))));
            if (min > d){
                min = d;
                ans = i;
            }
        }

        return (int)ans;
    }
}
