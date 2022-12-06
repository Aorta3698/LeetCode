class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] count = new int[100001];
        int uni = 0;
        for (int i = 0; i < k; i++)
            if (++count[nums[i]] == 1)
                ++uni;

        ans[0] = uni;
        for (int i = k; i < nums.length; i++){
            if(++count[nums[i]] == 1) uni++;
            if(--count[nums[i - k]] == 0) uni--;
            ans[i - k + 1] = uni;
        }

        return ans;
    }
}
