class Solution {
    public boolean check(int[] nums) {
        int descend = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                descend++;

        if (descend == 0) return true;
        if (descend >= 2) return false;
        return nums[0] >= nums[nums.length - 1];
    }
}
