https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/discuss/2282731/Java-or-Stream-or-3-Lines
class Solution {
    public int minimumSwaps(int[] nums) {
        int max = IntStream.range(0, nums.length).reduce((a,b)->nums[a]>nums[b]?a:b).getAsInt();
        int min = IntStream.range(0, nums.length).reduce((a,b)->nums[a]<=nums[b]?a:b).getAsInt();
        return nums.length-1-max+min-(max<min?1:0);
    }
}
