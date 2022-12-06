class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        Arrays.sort(nums);
        return dfs(nums, 0, sum / 2, new int[nums.length][sum / 2 + 1]);
    }

    private boolean dfs(int[] nums, int idx, int target, int[][] seen){
        if (target == 0) return true;
        if (idx == nums.length || nums[idx] > target) return false;
        if (seen[idx][target] != 0) return seen[idx][target] == 1;

        for (int i = idx; i < nums.length; i++)
            if (dfs(nums, i + 1, target - nums[i], seen)){
                seen[idx][target] = 1;
                return true;
            }

        seen[idx][target] = -1;
        return false;
    }
}
