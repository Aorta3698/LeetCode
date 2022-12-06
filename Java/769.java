class Solution {
    public int maxChunksToSorted(int[] arr) {
        int lo = 1, hi = arr.length;

        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            if (split(0, mid, 0, arr)){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }

        return lo;
    }

    private boolean split(int i, int j, int m, int[] arr){
        int min = arr.length, max = 0;
        for (int k = i; k < arr.length; k++){
            min = Math.min(min, arr[k]);
            max = Math.max(max, arr[k]);
            if (min < m)
                return false;
            if (max - min != k - i)
                continue;
            if (j > 0 && split(k + 1, j - 1, max, arr))
                return true;
        }

        return j == 0;
    }
}
