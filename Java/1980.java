class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] ans = new char[nums.length];
        for (int i = 0; i < nums.length; i++)
            ans[i] = (char)('1' - nums[i].charAt(i) + '0');
        // char[] ans = new char[nums.length];
        // backtrack(nums, 0, ans);
        // return String.valueOf(ans);
        return String.valueOf(ans);
    }

    // private boolean backtrack(String[] nums, int idx, char[] ans){
    //     if (idx == nums.length) return isDiff(nums, String.valueOf(ans));

    //     ans[idx] = '0';
    //     if (backtrack(nums, idx + 1, ans)) return true;
    //     ans[idx] = '1';
    //     return backtrack(nums, idx + 1, ans);
    // }

    // private boolean isDiff(String[] nums, String guess){
    //     for (String s : nums)
    //         if (s.equals(guess))
    //             return false;
    //     return true;
    // }
}
