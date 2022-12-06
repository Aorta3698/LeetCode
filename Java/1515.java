class Solution {
    public double getMinDistSum(int[][] A) {
        double[] a = new double[2];
        double[] b = new double[]{-1, -1};
        double esp = 1e-10, ans = 0;
        while(dist(a, b) > esp){
            double td = 0, ta = 0, tb = 0, d = 0;
            ans = 0;
            for (int[] p : A){
                d = dist(b, p);
                ans += d;
                ta += p[0]/d;
                tb += p[1]/d;
                td += 1/d;
            }
            a = b.clone();
            b[0]=ta/td;
            b[1]=tb/td;
        }
        return ans;
    }

    private double dist(double[] a, double[] b){
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(dx*dx+dy*dy);
    }

    private double dist(double[] a, int[] b){
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(dx*dx+dy*dy);
    }
}
