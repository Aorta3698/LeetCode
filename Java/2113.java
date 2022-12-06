https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/discuss/1647621/Java-or-O(N)-or-5-Lines-or-2-Conditions-Only
class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int n = nums.length, idx = 0;
        for (int[] q : queries){
            // if (q[0] % n == 0 && (q[0] / n) % 2 == 1) ans[idx] = -1;
            // if (q[0] % n == 0 && (q[0] / n) % 2 == 0) ans[idx] = nums[q[1]];
            if ((q[0] / n) % 2 == 0) ans[idx] = q[0] % n + q[1] >= n? -1 : nums[q[0] % n + q[1]];
            if ((q[0] / n) % 2 == 1) ans[idx] = q[1] >= q[0] % n? -1 : nums[q[1]];
            idx++;
        }

        return ans;
    }
}
