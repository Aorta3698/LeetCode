class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] > 0) sum += nums[i];
            else {max = Math.max(sum, max); sum = nums[i];}
        }

        return Math.max(max, sum);
    }
}
