class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int end = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i < intervals.length; i++){
            if (end >= intervals[i][1]) continue;
            end = intervals[i][1];
            ans++;
        }
        return ans;
    }
}
