class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int n : nums){
            sum += n;
            ans += map.getOrDefault(sum - goal, 0);
            map.merge(sum, 1, Integer::sum);
        }

        return ans;
    }
}
