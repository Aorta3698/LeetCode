https://leetcode.com/problems/find-missing-observations/discuss/1976260/Java-or-Greedy-Put-6-or-1
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int remain = mean * (rolls.length + n) - sum;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = remain - 6 >= (n - i - 1)? 6 : 1;
            remain -= ans[i];
        }
        ans[n - 1] += remain;
        return ans[n - 1] > 6 || ans[n - 1] <= 0? new int[]{} : ans;
    }
}
