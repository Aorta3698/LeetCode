class Solution {
    public int rob(int[] nums) {
        return commit(nums, 0, new HashMap<>());
    }

    private int commit(int[] nums, int start, HashMap<Integer, Integer> map){
        if (start >= nums.length) return 0;
        if (map.containsKey(start)) return map.get(start);
        int ans = Math.max(nums[start] + commit(nums, start + 2, map), commit(nums, start + 1, map));
        map.put(start, ans);
        return ans;
    }
}
