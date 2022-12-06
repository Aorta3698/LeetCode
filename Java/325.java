https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/1856274/Java-Concise-PrefixSum-%2B-HashMap
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        int pre = 0, ans = 0;
        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            ans = Math.max(i - map.getOrDefault(pre - k, i), ans);
            map.putIfAbsent(pre, i);
        }

        return ans;
    }
}
