class Solution {
    public int countElements(int[] nums) {
        int lim = (int)1e5+1, min = lim, max = -lim, maxc = 0, minc = 0;
        for (int n : nums){
            if (n > max){
                max = n;
                maxc = 0;
            }
            if (n < min){
                min = n;
                minc = 0;
            }
            if (n == max) maxc++;
            if (n == min) minc++;
        }

        return Math.max(0, nums.length - maxc - minc);
    }
}
