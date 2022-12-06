https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/discuss/1976405/Java-Fisher-Yates-Randomized-Solution
class Solution {
    public int[] rearrangeArray(int[] nums) {
        Random random = new Random();
        while(true){
            int i;
            for (i = 1; i < nums.length - 1; i++){
                if (2 * nums[i] == nums[i - 1] + nums[i + 1])
                    break;
            }
            if (i == nums.length - 1)
                return nums;
            for (i = 0; i < nums.length; i++){
                int j = i + random.nextInt(nums.length - i);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
