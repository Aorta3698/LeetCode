class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size() * 2];
        for (int i = 0; i < timePoints.size(); i++){
            String cur = timePoints.get(i);
            time[2 * i] = 60 * Integer.parseInt(cur.substring(0, 2)) + Integer.parseInt(cur.substring(3));
            time[2 * i + 1] = time[2 * i] + 24 * 60;
        }
        Arrays.sort(time);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < time.length; i++){
            ans = Math.min(ans, time[i] - time[i - 1]);
        }

        return ans;
    }
}
