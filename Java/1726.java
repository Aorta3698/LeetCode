class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                map.merge(nums[i] * nums[j], 1, Integer::sum);
                ans += map.get(nums[i] * nums[j]) - 1;
            }
        }

        return ans * 8;
    }
}
