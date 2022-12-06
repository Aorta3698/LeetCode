class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        gen(ans, new ArrayList<>(), candidates, 0, 0, target);
        return ans;
    }

    private void gen(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int idx, int sum, int target){
        if (sum == target){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (nums[idx] > target - sum) return;

        for (int i = idx; i < nums.length; i++){
            tmp.add(nums[i]);
            gen(ans, tmp, nums, i, sum + nums[i], target);
            tmp.remove(tmp.size() - 1);
        }
    }
}
