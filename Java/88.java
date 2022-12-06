class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        --m;--n;
        for (int i=m+n+1; i>=0; i--){
            A[i] = m < 0 || n >= 0 && B[n] > A[m]? B[n--] : A[m--];
        }
    }
}
