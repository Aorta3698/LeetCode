https://leetcode.com/problems/delete-and-earn/discuss/1605246/Java-10-lines-Space-O(1)-and-Speed-O(NLOGN)-with-Detailed-Explanation.
class Solution {
    public int deleteAndEarn(int[] nums) {
        //we have the choice to delete the last element or not delete it
        //also note that it makes sense to group all the same number together
        //dp[n] = Math.max(nums[n] * count + dp[n-1] or dp[n-2], dp[n-1]);
        //need to sort it first

        Arrays.sort(nums);

        int[] prev = new int[2];
        int[] cur = new int[2];
        int idx = 0;
        while(idx < nums.length){
            int n = nums[idx];
            int count = 0;
            while(idx < nums.length && nums[idx] == n){count++; idx++;}
            int picked = (n == cur[0] + 1)? n * count + prev[1] : n * count + cur[1];
            int next = Math.max(cur[1], picked);
            prev = cur;
            cur = new int[]{n, next};
        }

        return cur[1];
    }
}
