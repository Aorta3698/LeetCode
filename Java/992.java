class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k--) - atMost(nums, k);
    }

    private int atMost(int[] nums, int k){
        int n = nums.length, ans = 0;
        int[] cnt = new int[n + 1];
        for (int i = 0, j = 0, uni = 0; i < n; i++){
            if (++cnt[nums[i]] == 1) uni++;

            while(uni > k)
                if (--cnt[nums[j++]] == 0) uni--;

            ans += i - j + 1;
        }

        return ans;
    }
}
