class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, prevlo = 0, lo = 0, prevhi = 0, hi = n - 1;
        while(hi > 0 && lo < n - 1 && (prevlo != lo || prevhi != hi)){
            prevlo = lo; prevhi = hi;
            if (arr[lo + 1] > arr[lo]) ++lo;
            if (arr[hi - 1] > arr[hi]) --hi;
        }

        return lo != 0 && hi != n - 1 && lo == hi;
    }
}
