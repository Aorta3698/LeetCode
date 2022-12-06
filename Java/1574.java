class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, end = 0, start = n - 1;
        while(end < n - 1 && arr[end] <= arr[end + 1]){
            ++end;
        }
        while(start > 0 && arr[start] >= arr[start - 1]){
            --start;
        }
        if (end >= start){
            return 0;
        }

        int ans = end + 1;
        for (int i = 0; i <= end; i++){
            int lo = start, hi = n;
            while(lo < hi){
                int mid = (lo + hi) >> 1;
                if (arr[mid] >= arr[i]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            ans = Math.min(ans, end - i + lo - start);
        }

        return start - end - 1 + ans;
    }
}
