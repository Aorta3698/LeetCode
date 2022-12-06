class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int ans = 0;
        for (int i = 0; i < len; i++){
            int end = intervals[i][1];
            while(i < len - 1 && end > intervals[i + 1][0]){
                if (intervals[i + 1][1] > end){ans++; i++;}
                else {ans++; break;}
            }
        }

        return ans;
    }
}
