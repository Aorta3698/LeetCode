class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int n : nums){
            if (n > max) max = n;
            if (n < min) min = n;
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b){
        if (a == 0) return b;
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
