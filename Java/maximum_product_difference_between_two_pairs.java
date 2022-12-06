class Solution {
    public int maxProductDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums){
            if (n > max){
                secondMax = max;
                max = n;
            }else if (n > secondMax)
                secondMax = n;

            if (n < min){
                secondMin = min;
                min = n;
            }else if (n < secondMin)
                secondMin = n;
        }

        return max * secondMax - min * secondMin;
    }
}
