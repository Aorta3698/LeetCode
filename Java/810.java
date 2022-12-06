class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int n : nums){
            xor ^= n;
        }
        return xor == 0 || nums.length%2==0;
    }
}
