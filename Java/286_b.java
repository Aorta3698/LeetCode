class Solution {
    public int minDeletion(int[] nums) {
        int ans = 0;
        int d = 0;
        for (int i = 0; i < nums.length-1; i++){
            if (i % 2 == d && nums[i] == nums[i + 1]){
                ans++;
                d = 1 - d;
            }
        }
        if ((nums.length - ans) % 2 != 0){
            ++ans;
        }

        return ans;
    }
}
