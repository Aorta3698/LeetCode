class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0, ans = nums[0];
        for (int i = 0; i < nums.length-1; i++){
            int na = nums[i] + b;
            int nb = Math.max(a, b);
            a = na;
            b = nb;
            ans = Math.max(Math.max(ans, a), b);
        }
        a = b = 0;
        for (int i = 1; i < nums.length; i++){
            int na = nums[i] + b;
            int nb = Math.max(a, b);
            a = na;
            b = nb;
            ans = Math.max(Math.max(ans, a), b);
        }
        return ans;
    }
}
