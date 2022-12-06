class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] start = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++){
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }

        Arrays.sort(start, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[intervals.length];

        for (int i = 0; i < ans.length; i++){
            int lo = 0, hi = ans.length - 1;
            while(lo < hi){
                int mid = (hi + lo) >> 1;
                if (start[mid][0] >= intervals[i][1]){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            ans[i] = intervals[i][1] <= start[lo][0]? start[lo][1] : -1;
        }

        return ans;
    }
}
