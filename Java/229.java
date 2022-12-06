class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (map.merge(nums[i], 1, Integer::sum) == n / 3 + 1)
                ans.add(nums[i]);
        return ans;
    }
}
