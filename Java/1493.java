class Solution {
    public int longestSubarray(int[] nums) {
        int used = 0, free = 0, ans = 0;
        for (int n : nums){
            if (n == 0){
                used = free;
                free = 0;
            }else{
                used++;
                free++;
            }
            ans = Math.max(ans, Math.max(used, free));
        }

        return Math.min(nums.length - 1, ans);
    }
}
