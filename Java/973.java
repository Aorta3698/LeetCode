class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int lo = 0, hi = points.length-1;
        while(true){
            int mid = partition(points, lo, hi);
            if (mid == k){
                return Arrays.copyOf(points, k);
            }else if (mid > k){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
    }

    private int partition(int[][] A, int lo, int hi){
        int pivot = (hi+lo)>>1; // choose middle element as the pivot
        int cur = lo;
        int d = A[pivot][0]*A[pivot][0]+A[pivot][1]*A[pivot][1];
        int where=pivot;
        for (int i = lo; i <= hi; i++){
            if (A[i][0]*A[i][0]+A[i][1]*A[i][1] < d){
                if (cur == where){ // if we choose mid as pivot, we need to remember where it is.
                    where = i;
                }
                swap(A, i, cur++);
            }
        }
        if (cur < hi){
            swap(A, cur, where); // we MUST swap it.
        }
        return cur;
    }

    private void swap(int[][] A, int i, int j){
        int[] tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] ans = new int[k][2];
//         Arrays.sort(points, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
//         for (int i = 0; i < k; i++) ans[i] = points[i];
//         return ans;
//     }
// }
