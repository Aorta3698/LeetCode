https://leetcode.com/problems/maximum-erasure-value/discuss/1872042/99-Speed-Concise-Sliding-Window-Java
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, sum = 0;
        boolean[] seen = new boolean[10001];

        for (int i = 0, j = 0; i < nums.length; i++){
            while(seen[nums[i]]){
                seen[nums[j]] = false;
                sum -= nums[j++];
            }
            seen[nums[i]] = true;
            sum += nums[i];
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
