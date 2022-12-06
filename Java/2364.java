class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 1L*n*(n-1)/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            ans -= map.merge(nums[i]-i, 1, Integer::sum)-1;
        }
        return ans;
    }
}
