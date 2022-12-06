class Solution {
    public int numPoints(int[][] darts, int r) {
        int ans = 1, n = darts.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int x = darts[i][0], y = darts[i][1];
                int xx = darts[j][0], yy = darts[j][1];
                int[] vec = new int[]{x-xx, y-yy};
                double[] nor = new double[]{-vec[1], vec[0]};
                double[] mid = new double[]{(x+xx)/2., (y+yy)/2.};
                double m = dist(mid, darts[i]);
                double d = Math.sqrt(r*r-m*m);
                double scale = d/Math.sqrt(nor[0]*nor[0]+nor[1]*nor[1]);
                nor[0] *= scale;
                nor[1] *= scale;
                for (int s : new int[]{-1, 1}){
                    int count = 0;
                    double cx = s * nor[0] + mid[0];
                    double cy = s * nor[1] + mid[1];
                    double[] cir = new double[]{cx, cy};
                    for (int k = 0; k < n; k++){
                        if (dist(cir, darts[k]) <= r+1e-6){
                            count++;
                        }
                    }
                    ans = Math.max(count, ans);
                }
            }
        }
        return ans;
    }

    private double dist(int[] a, int[] b){
        int dx = Math.abs(a[0]-b[0]), dy = Math.abs(a[1]-b[1]);
        return Math.sqrt(dx*dx+dy*dy);
    }
    private double dist(double[] a, int[] b){
        double dx = Math.abs(a[0]-b[0]), dy = Math.abs(a[1]-b[1]);
        return Math.sqrt(dx*dx+dy*dy);
    }
}
