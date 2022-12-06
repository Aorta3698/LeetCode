https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/discuss/1847574/Java-or-2-candidates-and-2-cases
class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            return k % 2 == 0? nums[0] : -1;
        }

        int one = k >= nums.length? -1 : nums[k];
        int two = -1;
        for (int i = 0; i < Math.min(k - 1, nums.length); i++){
            two = Math.max(nums[i], two);
        }

        return Math.max(one, two);
    }
}
