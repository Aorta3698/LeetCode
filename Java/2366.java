class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length, cap = nums[n-1];
        for (int i = n-2; i >= 0; i--){
            if (nums[i]>cap){
                ans += (nums[i]-1)/cap;
                cap = nums[i]/((nums[i]+cap-1)/cap);
            }else{
                cap = nums[i];
            }
        }
        return ans;
    }
}
