class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int set = 0;
            for (int n : nums){
                if (((1 << i) & n) > 0){
                    set++;
                }
            }
            ans += set * (nums.length - set);
        }

        return ans;
    }
}
