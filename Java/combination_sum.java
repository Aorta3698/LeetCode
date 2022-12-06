class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            tmp.add(nums[i]);
            generate(nums, target - nums[i], i, tmp, ans);
            tmp.removeLast();
        }
    }
}
