class Solution {
    public boolean canPlaceFlowers(int[] A, int n) {
        for (int i = 0; i < A.length && n > 0; i++){
            if (A[i] == 0 && (i == 0 || A[i - 1] == 0) && (i == A.length - 1 || A[i + 1] == 0)){
                A[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
