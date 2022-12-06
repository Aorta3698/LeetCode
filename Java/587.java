class Solution {
    int CLOCKWISE = -1;
    int COLINEAR = 0;
    public int[][] outerTrees(int[][] A) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(A, Comparator.comparingInt(o -> o[0]+o[1]));
        boolean[] seen = new boolean[A.length];
        if (A.length <= 2){
            return A;
        }
        for (int i = 0,k=0,p=0; !seen[0]; p=i,i=k){
            for (int j = 0; j < A.length; j++){
                if (!seen[j] && j != p){
                    int dir = findDirABC(A[i], A[k], A[j]);
                    if (k == i || dir == CLOCKWISE || (dir == COLINEAR && dist(A[i], A[j]) < dist(A[i], A[k]))){
                        k=j;
                    }
                }
            }
            ans.add(A[k]);
            seen[k]=true;
        }
        return ans.toArray(new int[0][]);
    }

    private int findDirABC(int[] a, int[] b, int[] c){
        int ax = b[0]-a[0], ay = b[1]-a[1];
        int bx = c[0]-b[0], by = c[1]-b[1];
        return Integer.signum(ax*by-bx*ay);
    }

    private int dist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
