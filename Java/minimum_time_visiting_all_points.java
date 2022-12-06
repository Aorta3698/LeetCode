class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++){
            int[] cur = points[i];
            int[] next = points[i + 1];
            ans += Math.max(Math.abs(cur[0] - next[0]), Math.abs(cur[1] - next[1]));
        }

        return ans;
    }
}
