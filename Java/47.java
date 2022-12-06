class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.merge(n, 1, Integer::sum);
        }
        solve(nums.length, map, ans, new ArrayList<>());
        return ans;
    }

    private void solve(int k, Map<Integer, Integer> map, List<List<Integer>> ans, List<Integer> tmp){
        if (tmp.size() == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int key : map.keySet()){
            if (map.get(key) == 0)
                continue;
            map.merge(key, -1, Integer::sum);
            tmp.add(key);
            solve(k, map, ans, tmp);
            map.merge(key, 1, Integer::sum);
            tmp.remove(tmp.size() - 1);
        }
    }
}
