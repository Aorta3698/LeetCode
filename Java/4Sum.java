class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        gen(nums, 0, target, ans, new LinkedList<>());
        return ans;
    }

    private void gen(int[] nums, int start, int target,
            List<List<Integer>> ans, LinkedList<Integer> tmp){
        if (target == 0 && tmp.size() == 4){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        if (start == nums.length || tmp.size() == 4 && target != 0) return;

        for (int i = start; i < nums.length; i++){
            if (i == start || nums[i] != nums[i - 1]){
                long min = (long)nums[i] * (4 - tmp.size());
                long max = (long)nums[i] + (long)(3 - tmp.size()) * nums[nums.length - 1];
                if (min > target) return;
                if (max < target) continue;
                tmp.add(nums[i]);
                gen(nums, i + 1, target - nums[i], ans, tmp);
                tmp.removeLast();
            }
        }
    }
}
