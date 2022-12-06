class Solution {
    public double[] outerTrees(int[][] trees) {
        shuffle(trees);
        return solve(0, trees, new ArrayList<>());
    }

    private double[] solve(int idx, int[][] trees, List<int[]> edge){
        if (idx == trees.length || edge.size() == 3){
            return build(edge);
        }
        double[] ans = solve(idx+1, trees, edge);
        double r = ans[2];
        if (dist(ans, trees[idx]) <= r){
            return ans;
        }
        edge.add(trees[idx]);
        ans = solve(idx+1, trees, edge);
        edge.remove(edge.size()-1);
        return ans;
    }

    private double[] build(List<int[]> edge){
        if (edge.size() == 0){
            return new double[3];
        }
        int x = edge.get(0)[0], y = edge.get(0)[1];
        if (edge.size() == 1){
            return new double[]{x, y, 0};
        }else if (edge.size() == 2){
            int xx = edge.get(1)[0], yy = edge.get(1)[1];
            return new double[]{(xx+x)/2., (yy+y)/2., dist(edge.get(0), edge.get(1))/2};
        }else{
            int xx = edge.get(1)[0], yy = edge.get(1)[1];
            int xxx = edge.get(2)[0], yyy = edge.get(2)[1];
            int bx = xx-x,  by = yy-y;
            int cx = xxx-x, cy = yyy-y;
            long B = bx*bx+by*by;
            long C = cx*cx+cy*cy;
            long D = bx*cy-by*cx;
            double[] ans = new double[3];
            ans[0] = x+(cy*B-by*C)/(2.*D);
            ans[1] = y+(bx*C-cx*B)/(2.*D);
            ans[2] = dist(ans, edge.get(0));
            return ans;
        }
    }

    private double dist(int[] a, int[] b){
        int dx = Math.abs(a[0]-b[0]), dy = Math.abs(a[1]-b[1]);
        return Math.sqrt(dx*dx+dy*dy);
    }
    private double dist(double[] a, int[] b){
        double dx = Math.abs(a[0]-b[0]), dy = Math.abs(a[1]-b[1]);
        return Math.sqrt(dx*dx+dy*dy);
    }

    private void shuffle(int[][] A){
        Random random = new Random();
        for (int i = 0; i < A.length; i++){
            int j = random.nextInt(A.length-i)+i;
            int[] tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
