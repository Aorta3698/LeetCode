class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        gen(0, nums, ans, new LinkedList<>());
        return ans;
    }

    private void gen(int n, int[] nums, List<List<Integer>> ans, LinkedList<Integer> item){
        if (n == nums.length){
            ans.add(new ArrayList<>(item));
            return;
        }

        gen(n + 1, nums, ans, item);
        item.add(nums[n]);
        gen(n + 1, nums, ans, item);
        item.removeLast();
    }
}
