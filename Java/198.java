class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for (int n : nums){
            int na = n + b;
            int nb = Math.max(a, b);
            a = na;
            b = nb;
        }
        return Math.max(a, b);
    }
}
