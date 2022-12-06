class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int a = 0, b = 0, ans = 0;
        for (int n : nums){
            if (n < 0){
                int na = Math.max(0, b * n);
                int nb = Math.min(n, a * n);
                a = na;
                b = nb;
            }else if (n >= 0){
                a = Math.max(n, a * n);
                b = Math.min(n, b * n);
            }
            ans = Math.max(ans, a);
        }
        return ans;
    }
}
