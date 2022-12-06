class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                ans = Math.max(ans, dfs(i, nums, visited));
            }
        }
        return ans;
    }

    private int dfs(int i, int[] nums, boolean[] visited){
        if (visited[i])
            return 0;
        visited[i] = true;
        return 1 + dfs(nums[i], nums, visited);
    }
}
