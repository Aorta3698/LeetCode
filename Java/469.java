class Solution {
    public boolean isConvex(List<List<Integer>> A) {
        int d = 0;
        for (int i = 0; i < A.size(); i++){
            int t = getDir(A.get(i), A.get((i + 1) % A.size()), A.get((i + 2) % A.size()));
            if (d * Integer.signum(t) < 0)
                return false;
            if (d == 0)
                d = t;
        }
        return true;
    }

    private int getDir(List<Integer> a, List<Integer> b, List<Integer> c){
        return (c.get(0) - b.get(0)) * (b.get(1) - a.get(1)) - (c.get(1) - b.get(1)) * (b.get(0) - a.get(0));
    }
}
