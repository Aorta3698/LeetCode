class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums){
            max = Math.max(n, max);
            min = Math.min(n, min);
        }

        return nums.length == 1 || max == min? 0 : Math.max(max - min - 2 * k, 0);
    }
}
