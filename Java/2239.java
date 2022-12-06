class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int n : nums){
            if (Math.abs(n) < Math.abs(ans)){
                ans = n;
            }else if (Math.abs(n) == Math.abs(ans) && n > ans){
                ans = n;
            }
        }
        return ans;
    }
}
