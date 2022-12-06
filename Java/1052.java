class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int count = 0, ans = 0, sum = 0;
        for (int i = 0; i < grumpy.length; i++){
            if (grumpy[i] == 1){
                count += customers[i];
            }
            if (i >= minutes && grumpy[i - minutes] == 1){
                count -= customers[i - minutes];
            }
            if (grumpy[i] == 0){
                sum += customers[i];
            }
            ans = Math.max(ans, count);
        }

        return ans + sum;
    }
}
