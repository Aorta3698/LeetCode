class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++){
            int n = nums[i];
            nums[i] = a*n*n+b*n+c;
        }
        Arrays.sort(nums);
        return nums;
    }
}
