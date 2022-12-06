class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = IntStream.rangeClosed(1, 9).toArray();
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, k, n, new LinkedList<>(), ans);
        return ans;
    }

    private void generate(int[] nums, int start, int limit, int target, LinkedList<Integer> tmp,
            List<List<Integer>> ans){

        if (start == nums.length || tmp.size() == limit || target < nums[start]){
            if (target == 0 && tmp.size() == limit)
                ans.add(new ArrayList<>(tmp));
            return;
        }

        generate(nums, start + 1, limit, target, tmp, ans);
        tmp.add(nums[start]);
        generate(nums, start + 1, limit, target - nums[start], tmp, ans);
        tmp.removeLast();
    }
}
