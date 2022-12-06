class Solution {
    public boolean isBoomerang(int[][] points) {
        double[] dist = new double[3];
        double s = 0;
        for (int i = 0; i < 3; i++){
            dist[i] = dist(points[i], points[(i + 1) % 3]);
            s += dist[i] / 2;
        }

        return Double.compare(s * (s - dist[0]) * (s - dist[1]) * (s - dist[2]), 0.000001) > 0;
    }

    private static double dist(int[] o, int[] t){
        return Math.sqrt(Math.pow(o[0] - t[0], 2) + Math.pow(o[1] - t[1], 2));
    }
}
