class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < ans.length; i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                if (sum + nums[j] > queries[i]){
                    ans[i] = j;
                    break;
                }
                sum += nums[j];
            }
            if (ans[i] == -1){
                ans[i] = nums.length;
            }
        }
        return ans;
    }
}
