class Solution {
    public int minSwaps(int[] nums) {
        int len = 0, ans = 0, cnt = 0, copy = 0;
        for (int n : nums) if (n == 1) len++;
        for (int i = 0; i < len; i++) if (nums[i] == 0) cnt++;
        ans = copy = cnt;

        for (int left = len - 1, right = nums.length - 1; left >= 0; left--, right--){
            if (nums[left] == 0) copy--;
            if (nums[right] == 0)copy++;
            ans = Math.min(copy, ans);
        }

        for (int i = len; i < nums.length; i++){
            if (nums[i] == 0) cnt++;
            if (nums[i - len] == 0) cnt--;
            ans = Math.min(cnt, ans);
        }

        return ans;
    }
}
