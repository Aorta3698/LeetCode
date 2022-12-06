class Solution {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comp = Comparator.comparingInt(p -> p[1]);
        Arrays.sort(points, comp);
        int ans = 0;
        for (int i = 0; i < points.length; i++){
            int copy = i;
            while(i < points.length -1 && points[copy][1] >= points[i + 1][0]) i++;
            ans++;
        }
        return ans;
    }
}
