class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        int sum = 0, ans = 0;
        for (int n : nums){
            sum += n;
            ans += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }

        return ans;
    }
}
