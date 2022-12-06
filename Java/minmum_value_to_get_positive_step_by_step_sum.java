class Solution {
    public int minStartValue(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums){
            sum += i;
            minSum = Math.min(sum, minSum);
        }

        return minSum < 0? Math.abs(minSum) + 1 : 1;
    }
}
