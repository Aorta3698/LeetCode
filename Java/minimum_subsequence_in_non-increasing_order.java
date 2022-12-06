class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int j = 0;
        for (int i = nums.length - 1; i >= 0; --i){
            sum -= nums[i];
            j += nums[i];
            ans.add(nums[i]);
            if (j > sum) break;
        }

        return ans;
    }
}
