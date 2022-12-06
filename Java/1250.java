class Solution {
    public boolean isGoodArray(int[] nums) {
        int a = nums[0];
        for (int n : nums){
            a=gcd(a, n);
        }
        return a==1;
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }
}
