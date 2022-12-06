class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));

        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            if (map.containsKey(pre - target)){
                map.clear();
                ans++;
            }
            map.put(pre, i);
        }

        return ans;
    }
}
