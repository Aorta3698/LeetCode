class Solution {
    public int countQuadruplets(int[] nums) {
        return count(nums, 0, 0, 0);
    }

    private int count(int[] nums, int start, int cnt, int sum){
        int ans = 0;
        for (int i = start; i < nums.length; i++)
            {
                if (cnt == 3 && nums[i] == sum) ans += 1;
                if (cnt != 3) ans += count(nums, i + 1, cnt + 1, sum + nums[i]);
            }

        return ans;
    }
}
