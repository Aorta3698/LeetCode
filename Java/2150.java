class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.merge(n, 1, Integer::sum);
        for (int n : nums)
            if (map.get(n) == 1 && map.get(n - 1) == null && map.get(n + 1) == null)
                ans.add(n);
        return ans;
    }
}
