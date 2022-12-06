class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                for (int w = j + 1; w < points.length; w++){
                    int r = points[i][0], e = points[i][1];
                    int x = points[j][0], y = points[j][1];
                    int u = points[w][0], o = points[w][1];
                    double a = dist(r, e, x, y);
                    double b = dist(r, e, u, o);
                    double c = dist(u, o, x, y);
                    double s = (a + b + c) / 2;
                    max = Math.max(s * (s - a) * (s - b) * (s - c), max);
                }
            }
        }
        return Math.sqrt(max);
    }

    private static double dist(int a, int b, int x, int y){
        return Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
    }
}
