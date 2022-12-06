class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, prev = nums[0], cnt = 0;
        for (int n : nums){
            if (n > prev) cnt++;
            if (n <=prev) {ans = Math.max(cnt, ans); cnt = 1;}
            prev = n;
        }

        return Math.max(ans, cnt);
    }
}
