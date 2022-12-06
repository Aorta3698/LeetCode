class Solution {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; ++j){
                if (i == j || nums[i].length() + nums[j].length() != target.length()) continue;
                if (target.equals(nums[i] + nums[j])) ans++;
            }
        }

        return ans;
    }
}
