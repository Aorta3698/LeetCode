class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates, target, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void generate(int[] nums, int target, int start, LinkedList<Integer> tmp,
            List<List<Integer>> ans){
        if (target <= 0){
            if (!tmp.isEmpty() && target == 0)
                ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++){
            if (i != start && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            generate(nums, target - nums[i], i + 1, tmp, ans);
            tmp.removeLast();
        }
    }
}
