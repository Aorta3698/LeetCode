class Solution {
    public int missingNumber(int[] nums) {
        return ((nums.length + 1) * nums.length)/2 - Arrays.stream(nums).sum();
    }
}
