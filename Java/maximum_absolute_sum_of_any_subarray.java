class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int sum = 0;
        int oppositeSum = 0;
        for (int n : nums){
            sum = Math.abs(sum + n) < Math.abs(n + oppositeSum)? n + oppositeSum : sum + n;
            max = Math.max(max, Math.abs(sum));
            oppositeSum = (sum * n > 0 || sum == n)? 0 : oppositeSum + n;
        }

        return max;
    }
}
