class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        gen(0, nums, ans, new LinkedList<>());
        return new ArrayList<>(ans);
    }

    private void gen(int n, int[] nums, Set<List<Integer>> ans, LinkedList<Integer> item){
        if (n == nums.length){
            ArrayList<Integer> cand = new ArrayList<>(item);
            Collections.sort(cand);
            ans.add(cand);
            return;
        }

        gen(n + 1, nums, ans, item);
        item.add(nums[n]);
        gen(n + 1, nums, ans, item);
        item.removeLast();
    }
}
