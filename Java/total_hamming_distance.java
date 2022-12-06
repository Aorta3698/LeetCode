class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                count += getDist(nums[i], nums[j]);
        return count;
    }

    private int getDist(int i, int j){
        int xor = i^j;
        int count = 0;
        while(xor > 0){
            count += xor % 2;
            xor >>= 1;
        }

        return count;
    }
}
