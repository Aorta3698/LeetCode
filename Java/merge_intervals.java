class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i < intervals.length - 1 && end >= intervals[i + 1][0])
                end = Math.max(end, intervals[i++ + 1][1]);
            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[0][]);
    }
}
