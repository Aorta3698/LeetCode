class Solution {
    public int fixedPoint(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (mid > arr[mid]) lo = mid + 1;
            if (mid <= arr[mid]) hi = mid;
        }

        return arr[lo] == lo? lo : -1;
        // int lo = 0, hi = arr.length - 1, ans = -1;
        // while(lo <= hi){
        //     int mid = lo + (hi - lo) / 2;
        //     if (mid == arr[mid]) ans = mid;
        //     if (mid > arr[mid]) lo = mid + 1;
        //     if (mid <= arr[mid]) hi = mid - 1;
        // }

        // return ans;
    }
}
