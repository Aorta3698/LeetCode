class Solution {
    public double minAreaFreeRect(int[][] points) {
        double min = Double.POSITIVE_INFINITY;
        int len = points.length;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++){
                if (i == j) continue;
                for (int w = 0; w < len; w++){
                    if (w == i || w == j) continue;
                    for (int o = 0; o < len; o++){
                        if (o == w || o == j || o == i) continue;
                        if (dot(points[i], points[w], points[j]) &&
                                dot(points[j], points[o], points[w]) &&
                                dot(points[w], points[i], points[o]))
                            min = Math.min(min, dist(points[i], points[j]) * dist(points[j], points[w]));
                    }
                }
            }

        return min == Double.POSITIVE_INFINITY? 0 : min;
    }

    private double dist(int[] a, int[] b){
        int x = a[0];
        int y = a[1];
        int dx= b[0];
        int dy= b[1];
        return Math.sqrt((x - dx) * (x - dx) + (y - dy) * (y - dy));
    }

    private boolean dot(int[] a, int[] b, int[] c){
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        int x3 = c[0];
        int y3 = c[1];
        return (x1 - x3) * (x2 - x3) + (y1 - y3) * (y2 - y3) == 0;
    }
}
