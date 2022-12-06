class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int[] count = new int[100001];
        int max = 0;
        for (int n : nums){
            max = Math.max(max, ++count[n]);
        }
        return 1L*max*k <= nums.length;
    }
}
