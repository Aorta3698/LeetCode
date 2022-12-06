https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/discuss/1656254/TLE-is-Likely-when-Memo-is-Used.-From-TLE-to-4ms-100
class Solution {
    public int minOperations(int[] nums) {
        int odd = 0, even = 1;
        for (int n : nums){
            odd += Integer.bitCount(n);
            int cnt = 0;
            while(n > 0){
                n >>= 1;
                cnt++;
            }
            even = Math.max(cnt, even);
        }

        return odd + even - 1;
    }
}
