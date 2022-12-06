https://leetcode.com/problems/max-points-on-a-line/discuss/1615612/Java-or-10-Lines-or-Explanations-w-Picture
class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        DecimalFormat df = new DecimalFormat("#.##########");
        HashMap<Map.Entry<String, String>, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                double slope = points[i][0] - points[j][0] == 0? Double.POSITIVE_INFINITY :
                    (double)(points[i][1] - points[j][1]) / (double)(points[i][0] - points[j][0]);
                double id = slope == Double.POSITIVE_INFINITY? points[i][0]
                    : (double)points[i][1] - (double)points[i][0] * slope;

                max = Math.max(map.merge(Map.entry(df.format(id), df.format(slope)), 1, Integer::sum), max);
            }
        }

        return (int)Math.sqrt(2 * max) + 1;
    }
}
