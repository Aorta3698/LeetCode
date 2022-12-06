class Solution {
    public long kthSmallestProduct(int[] A, int[] B, long k) {
        int a = A.length, b = B.length;
        int x = (int)Arrays.stream(A).filter(o -> o < 0).count();
        int y = (int)Arrays.stream(B).filter(o -> o < 0).count();
        long L = 1L*x*(b-y)+1L*y*(a-x); // neg
        return L >= k?
            solveL(x, y, A, B, k) :
            solveR(x, y, A, B, k-L);
    }

    private long solveR(int x, int y, int[] A, int[] B, long k){
        int a = A.length, b = B.length;
        long lo = 0, hi = (long)1e10;
        while(lo < hi){
            long mid = (lo+hi)>>1;
            long count = countRN(x, y, mid, A, B) + countRP(x, y, mid, A, B);
            if (count >= k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    private long solveL(int x, int y, int[] A, int[] B, long k){
        int a = A.length, b = B.length;
        long lo = (long)-1e10, hi = 0;
        while(lo < hi){
            long mid = (lo+hi)>>1;
            long count = countL(x, y, mid, A, B) + countL(y, x, mid, B, A);
            if (count >= k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    private long countL(int x, int y, long mid, int[] A, int[] B){
        int b = B.length;
        long count = 0;
        for (int i = 0, j = y; i < x; i++){
            while(j<b && 1L*A[i]*B[j]>mid){
                ++j;
            }
            count += b-j;
        }
        return count;
    }

    private long countRN(int x, int y, long mid, int[] A, int[] B){
        int b = B.length;
        long count = 0;
        for (int i = 0, j = y-1; i < x; i++){
            while(j >= 0 && 1L*A[i]*B[j]<=mid){
                --j;
            }
            count += y-1-j;
        }
        return count;
    }

    private long countRP(int x, int y, long mid, int[] A, int[] B){
        int b = B.length;
        long count = 0;
        for (int i = x, j = b-1; i < A.length; i++){
            while(j>=y && 1L*A[i]*B[j]>mid){
                --j;
            }
            count += j-(y-1);
        }
        return count;
    }
}
