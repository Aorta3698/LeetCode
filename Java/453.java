class Solution {
    public int minMoves(int[] nums) {
        return (int)(Arrays.stream(nums).asLongStream().sum()
            - 1L * nums.length * Arrays.stream(nums).min().getAsInt());
    }
}
