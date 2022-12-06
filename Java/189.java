class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] ans = new int[n];
        for (int i = -k; i < n - k; i++) ans[i + k] = nums[(i + n) % n];
        for (int i = 0; i < n; i++) nums[i] = ans[i];
    }
}
