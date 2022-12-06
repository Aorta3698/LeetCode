https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/discuss/2215406/Java-or-Longest-task-greater-Fastest-person-or-Explained.
class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for (int i = 0; i < jobs.length; i++){
            ans = Math.max(--jobs[i]/workers[i]+1, ans);
        }
        return ans;
    }
}
