class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sec = max;
        for (int n : nums){
            if (n > max){
                sec = max;
                max = n;
            }else if (n > sec)
                sec = n;
        }

        return (sec - 1) * (max - 1);
    }
}
