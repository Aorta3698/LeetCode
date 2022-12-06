class Solution {

    private double r;
    private double x;
    private double y;
    // private Random random;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        // random = new Random();
    }

    public double[] randPoint() {
        double dx = Double.MAX_VALUE, dy = 0;
        while(dx * dx + dy * dy > r * r){
            dx = 2*r * Math.random() - r;
            dy = 2*r * Math.random() - r;
            // dx = r * Math.random() * Math.pow(-1, random.nextInt(2));
            // dy = r * Math.random() * Math.pow(-1, random.nextInt(2));
        }

        return new double[]{x + dx, y + dy};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
