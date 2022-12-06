class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = (int)-1e9, hi = -lo;
        while(lo < hi){
            int mid = (lo+hi)>>1, count = 0, i = matrix.length-1, j = 0;
            while(i >= 0){
                while(j < matrix.length && matrix[i][j] <= mid){
                    ++j;
                }
                count += j;
                --i;
            }
            if (count >= k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
