class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        // if (arr[0] <= x)
        // if (arr[0] <= x) return List.of(Arrays.copyOfRange(arr, 0, k));
        // if (arr[len - 1] <= x) return List.of(Arrays.copyOfRange(arr, len-k, len));
        // if (k == len) return List.of(arr);

        int hi = len - 1;
        int lo = 0;
        int idx = -1;
        while(lo+1 < hi){
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > x) hi = mid;
            if (arr[mid] < x) lo = mid;
            if (arr[mid] == x){
                idx = mid;
                break;
            }
        }

        if (idx == -1)
            idx = x - arr[lo] > arr[hi] - x? hi : lo;

        lo = idx;
        hi = idx;
        for (int i = 1; i < k; i++){
            if (lo == 0){
                hi++;
                continue;
            }
            if (hi == arr.length-1){
                lo--;
                continue;
            }

            if (x - arr[lo - 1] <= arr[hi + 1] - x) lo--;
            else hi++;
        }

        return Arrays.stream(Arrays.copyOfRange(arr, lo, hi + 1)).boxed().collect(Collectors.toList());
    }
}
