class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int a = numsDivide[0];
        for (int i = 1; i < numsDivide.length&&a>1; i++){
            a=gcd(a,numsDivide[i]);
        }
        for (int i = 0; i < nums.length; i++){
            if (a%nums[i]==0){
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b){
        return a==0?b:gcd(b%a,a);
    }
}
